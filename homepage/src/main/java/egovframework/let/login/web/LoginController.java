package egovframework.let.login.web;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.let.Join.service.JoinService;
import egovframework.let.Join.service.JoinVO;
import egovframework.let.api.naver.service.NaverLoginService;
import egovframework.let.uat.uia.service.EgovLoginService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class LoginController {

	@Resource(name = "loginService")
	private EgovLoginService loginService;

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	

	//22.09.07
	@Resource(name = "naverLoginService")
	private NaverLoginService naverLoginService;
	
	//22.09.07
	@Resource(name = "joinService")
	private JoinService joinService;
	

	// 로그인
	@RequestMapping(value = "/login/actionLogin.do")
	public String actionLogin(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, ModelMap model)
			throws Exception {

//		로그인 한 사람의 상세정보를 가지고 와서 체크
//		상세정보가 있다 == 아이디와 패스워드 정보가 맞다
		LoginVO resultVO = loginService.actionLogin(loginVO);
		if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("")) {
			request.getSession().setAttribute("LoginVO", resultVO);
//			로그인 한 정보를 session에 담아서 사용하기
			return "forward:/mainpage.do";
		} else {	//아이디와 패스워드 정보가 맞지 않은 경우
			model.addAttribute("loginMessage", egovMessageSource.getMessage("fail.common.login"));
//			/homepage/src/main/resources/egovframework/message/com 아래의 message에서 가지고 오는 msg
			return "forward:/mainpage.do";
		}
	}

	// 로그아웃
	@RequestMapping(value = "/login/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {

//		로그아웃 방법(2)
//		1.작업한 모든 세션 정보 다 삭제
//		2.LoginVO 날려버리기
		
//		RequestContextHolder.getRequestAttributes().removeAttribute("LoginVO", RequestAttribute.SCOPE_SESSION);
		request.getSession().invalidate();

		return "forward:/mainpage.do";
	}
	
	//22.09.07 네이버 로그인 콜백
	@RequestMapping(value = "/login/naverLogin.do")
	public String naverLogin(@ModelAttribute("loginVO") LoginVO loginVO, @RequestParam String code, @RequestParam String state,
			HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		// code, state 값은 무조건 프로세스 진행을 위해 받아야 필수 하는 값
		// 두 값이 없으면 바로 오류가 나요 ~~> 차단!
		
		String domain = request.getServerName();
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginService.getAccessToken(session, code, state, domain);
		
		//로그인 사용자 정보를 읽어온다.
		String apiResult = naverLoginService.getUserProfile(oauthToken);
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		JSONObject result = (JSONObject) jsonObj.get("response");
		
		loginVO.setId("NAVER-" + result.get("id").toString());
		loginVO.setPassword("");
		loginVO.setUserSe("USR");
		
		LoginVO resultVO = loginService.actionLogin(loginVO);
		//로그인 값이 없으면 회원가입처리
		if(resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("")) {
			request.getSession().setAttribute("LoginVO", resultVO);
			return "forward:/mainpage.do";
		}else {
			//일반가입을ㅇ 제외하고는 ID 값은 SNS명 + ID값
			JoinVO joinVO = new JoinVO();
			
			joinVO.setEmplyrId(loginVO.getId());
			joinVO.setUserNm(result.get("name").toString());
			joinVO.setPassword("");
			joinVO.setPasswordHint("SNS가입자");
			joinVO.setPasswordCnsr("SNS가입자");
			
			joinService.insertJoin(joinVO);
			model.addAttribute("loginMessage", "회원가입 완료.");
			
			return "forward:/index.do";
		}
			
	}
	
}