package egovframework.let.practice.service;

import java.util.List;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface PracticeService {
	//임시데이터 가져오기
	public PracticeVO selectPractice(PracticeVO vo) throws Exception;
	
	//임시데이터 목록 가져오기: controller에서 필요
	public List<EgovMap> selectPracticeList(PracticeVO vo) throws Exception;
	
	//임시데이터 가져오기
	public String insertPractice(PracticeVO vo) throws Exception;
	
	//임시데이터 수정하기
	public void updatePractice(PracticeVO vo) throws Exception;
	
	//임시데이터 삭제하기
	public void deletePractice(PracticeVO vo) throws Exception;
	
	//임시데이터 목록 수: controller에서 필요
	public int selectPracticeListCnt(PracticeVO vo) throws Exception;
	
}