package egovframework.let.practice.service.impl;
import java.util.List;

import egovframework.let.practice.service.PracticeVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Mapper("practiceMapper")
public interface PracticeMapper {
	
	//임시데이터 가져오기
	PracticeVO selectPractice(PracticeVO vo) throws Exception;
	
	//임시데이터 목록 가져오기
	List<EgovMap> selectPracticeList(PracticeVO vo) throws Exception;
	
	//임시데이터 등록
	//아직은 딱히 DB에서 받아오는 값이 없어서 void
	void insertPractice(PracticeVO vo) throws Exception;
	
	//임시데이터 수정하기
	void updatePractice(PracticeVO vo) throws Exception;
	
	//임시데이터 삭제하기
	void deletePractice(PracticeVO vo) throws Exception;
	
	//임시데이터 목록 수
	int selectPracticeListCnt(PracticeVO vo) throws Exception;

}
