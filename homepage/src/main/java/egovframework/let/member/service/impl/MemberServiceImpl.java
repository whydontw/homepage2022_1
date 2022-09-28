package egovframework.let.member.service.impl;

import java.util.List;

import egovframework.let.member.service.MemberService;
import egovframework.let.member.service.MemberVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {

	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@Resource(name="egovMemberIdGnrService")
	EgovIdGnrService egovIdGnrService;

	@Override
	public List<MemberVO> selectMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVO vo) {
		return  memberDao.insertMember(vo);
	}

	@Override
	public MemberVO selectMember(String memId) {
		return  memberDao.selectMember(memId);
	}


//	@Override
//	public int updateMember(MemberVO vo) {
//		return  memberdao.updateMember(vo);
//	}
//
//	@Override
//	public int delMember(String memId) {
//		return  memberdao.delMember(memId);
//	}

	
}
