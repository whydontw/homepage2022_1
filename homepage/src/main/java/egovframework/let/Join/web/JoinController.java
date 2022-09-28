package egovframework.let.Join.web;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.let.Join.service.JoinService;
import egovframework.let.Join.service.JoinVO;
import egovframework.let.api.naver.service.NaverLoginService;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import net.sf.json.JSONObject;

@Controller
public class JoinController {

	@Resource(name = "joinService") // impl에서 연결
	private JoinService joinService;

	@Resource(name = "egovMessageSource") // impl에서 연결
	EgovMessageSource egovMessageSource;
	
	//22.09.07
	@Resource(name = "naverLoginService")
	private NaverLoginService naverLoginService;
	

	// 회원 구분
	@RequestMapping(value = "/join/memberType.do")
	public String memberType(@ModelAttribute("searchVO") JoinVO vo, // searchVO가 CrudVO를 불러오게끔
			HttpServletRequest request, ModelMap model, HttpSession session) throws Exception {
		
		//22.09.07 naver -----------------------
		String domain = request.getServerName();
		String naverAuthUrl = naverLoginService.getAuthorizationUrl(session, domain);
		model.addAttribute("naverAuthUrl", naverAuthUrl);
		//--------------------------------------

		return "join/MemberType";
	}

	// 회원등록 폼
	@RequestMapping(value = "/join/memberRegist.do") // uri 입력
	public String memberRegist(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model)
			throws Exception {

		return "join/MemberRegist";
	}

	// 회원가입
	@RequestMapping(value = "/join/insertMember.do")
	public String insertMember(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model)
			throws Exception {

		if (!EgovStringUtil.isEmpty(vo.getLoginType())) {
			// 일반가입을 제외하고는 ID값은 SNS명 + ID값
			if (!("normal").equals(vo.getLoginType())) {
				vo.setEmplyrId(vo.getLoginType() + "-" + vo.getEmplyrId());	//ID 규칙
				vo.setPassword("");	//null이 아닌 빈공간
				vo.setPasswordHint("SNS가입자");
				vo.setPasswordCnsr("SNS가입자");
			}
		}

		//중복회원가입을 방지하기 위함
		if (joinService.duplicateCheck(vo) > 0) {
			
			model.addAttribute("message", egovMessageSource.getMessage("fail.duplicate.member"));
			// 이미 사용 중인 ID입니다.
			return "forward:/join/memberType.do";
		} else {
			joinService.insertJoin(vo);
			model.addAttribute("message", egovMessageSource.getMessage("join.request.msg"));
			// 회원신청이 정상적으로 완료되었습니다. 로그인 후 이용해주세요.
		}
		return "forward:/mainpage.do";
	}
	
	
	//아이디 중복체크
	@RequestMapping(value = "/join/duplicateCheck.do")
	public void duplicateCheck(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {
		String successYn = "Y";
		String message = "성공";
		
		JSONObject jo = new JSONObject();
		response.setContentType("application/json; charset=utf-8"); //== 기본형은 text인데 선언함으로서 json으로 보낸다
		
		int duplicateCnt = joinService.duplicateCheck(vo);
		if(duplicateCnt > 0) {
			successYn = "N";
			message = egovMessageSource.getMessage("fail.duplicate.member"); //이미 사용중인 ID입니다.
		}
		
		jo.put("successYn", successYn);
		jo.put("message", message);
	
	//페이지에 json을 뿌려주기
	PrintWriter printwriter = response.getWriter();
	printwriter.println(jo.toString());
	printwriter.flush(); //열었으면
	printwriter.close(); //닫아주자
	
	}
}
