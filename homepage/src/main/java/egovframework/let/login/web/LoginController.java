package egovframework.let.login.web;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.let.uat.uia.service.EgovLoginService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Resource(name = "loginService")
	private EgovLoginService loginService;

	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

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
	
}