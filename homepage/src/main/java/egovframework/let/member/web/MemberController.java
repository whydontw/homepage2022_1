package egovframework.let.member.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;

@Controller
public class MemberController {

	@Resource(name="memberService")
	private MemberService memberService;

	@GetMapping("/member/list.do")
	public String list(Map<String, Object> map){ // model, map... 사용
		List<MemberVO> list = memberService.selectMemberList();
		map.put("memList", list); // memList라는 이름으로 model에 저장

		return "member/MemberList";
	}

	
	@GetMapping("/member/add.do")
	public String addForm() {
		
		return "member/MemberRegist";
	}

	@PostMapping("/member/add.do")
	public String add(MemberVO vo) {
		System.out.println(vo);
		int num = memberService.insertMember(vo);
		return "redirect:/mainpage.do";
	}


	/*
	@GetMapping("/member/edit.do")
	public String editForm(String memId, Map<String, Object> map) {
//		String memId = req.getParameter("memId");
		MemberVO vo = memberService.selectMember(memId);
		map.put("memVo", vo);
		return "member/MemberEdit";
	}

	@PostMapping("/member/edit.do")
	public String edit(MemberVO vo) {

		int num = memberService.updateMember(vo);
		return "redirect:/mainpage.do";
	}

	@GetMapping("/member/del.do")
	public String del(String memId) {
		int num = memberService.delMember(memId);
		return "redirect:/member/list.do";
	}
	*/
}
