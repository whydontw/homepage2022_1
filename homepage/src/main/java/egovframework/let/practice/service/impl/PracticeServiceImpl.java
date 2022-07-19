package egovframework.let.practice.service.impl;

import java.util.List;

import egovframework.let.practice.service.PracticeService;
import egovframework.let.practice.service.PracticeVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("practiceService")
//어노테이션의 파일명의 첫글자는 소문자로 항상 시작한다
public class PracticeServiceImpl extends EgovAbstractServiceImpl implements PracticeService {

	@Resource(name = "practiceMapper")
	private PracticeMapper practiceMapper;
	
	@Resource(name = "egovPracticeIdGnrService")
	private EgovIdGnrService idgenService;	
		
	@Override
	public PracticeVO selectPractice(PracticeVO vo) throws Exception {
		return practiceMapper.selectPractice(vo);
	}
	
	//Practice 목록 가져오기
	@Override
	public List<EgovMap> selectPracticeList(PracticeVO vo) throws Exception {
		return practiceMapper.selectPracticeList(vo);
	}
	
	//임시데이터 등록하기
	//tempMapper.insertTemp(vo)의 값이 void인데 우리는 string값으로 받아와야하기 때문에 return값이 null
	@Override
	public String insertPractice(PracticeVO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setPracticeId(id);
		practiceMapper.insertPractice(vo);
		return id;
	}
	
	//임시데이터 수정하기
	@Override
	public void updatePractice(PracticeVO vo) throws Exception{
		practiceMapper.updatePractice(vo);
	}
	
	//임시데이터 삭제하기
	@Override
	public void deletePractice(PracticeVO vo) throws Exception{
		practiceMapper.deletePractice(vo);
	}
	
	//임시데이터 목록 수
	@Override
	public int selectPracticeListCnt(PracticeVO vo) throws Exception{
		return practiceMapper.selectPracticeListCnt(vo);
	}

}
