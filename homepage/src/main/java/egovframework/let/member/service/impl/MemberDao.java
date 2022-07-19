package egovframework.let.member.service.impl;
import java.util.List;

import egovframework.let.crud.service.CrudVO;
import egovframework.let.member.service.MemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Mapper("memberDao")
public interface MemberDao {

	List<MemberVO> selectMemberList();
	
	int insertMember(MemberVO vo);

	MemberVO selectMember(String memId);

//	int updateMember(MemberVO vo);
//
//	int delMember(String memId);
		
}
