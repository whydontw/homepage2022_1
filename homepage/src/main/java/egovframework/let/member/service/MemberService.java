package egovframework.let.member.service;

import java.util.List;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MemberService {

	List<MemberVO> selectMemberList();

	int insertMember(MemberVO vo);

	MemberVO selectMember(String memId);

//	int updateMember(MemberVO vo);
//
//	int delMember(String memId);
	
}