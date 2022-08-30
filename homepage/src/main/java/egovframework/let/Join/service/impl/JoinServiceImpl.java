package egovframework.let.Join.service.impl;

import java.util.List;

import egovframework.let.Join.service.JoinService;
import egovframework.let.Join.service.JoinVO;
import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("joinService") //controller와 연결
public class JoinServiceImpl extends EgovAbstractServiceImpl implements JoinService {

	@Resource(name = "joinMapper")
	private JoinMapper joinMapper;
	
	@Resource(name = "joinIdGnrService")
	private EgovIdGnrService idgenService;
	
	
	//회원등록
	
	@Override
	public String insertJoin(JoinVO vo) throws Exception{
		
		String esntlId = idgenService.getNextStringId();
		vo.setEsntlId(esntlId);
		
		//입력한 비밀번호를 암호화한다.
		String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getEmplyrId());
		vo.setPassword(enpassword);
		
		joinMapper.insertJoin(vo);
		return esntlId;
	}

	//아이디 중복체크
	@Override
	public int duplicateCheck(JoinVO vo) throws Exception {
		return joinMapper.duplicateCheck(vo);
	}	
}
