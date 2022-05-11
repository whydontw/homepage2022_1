package egovframework.let.crud.service.impl;
import java.util.List;

import egovframework.let.crud.service.CrudVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Mapper("crudMapper")
public interface CrudMapper {
	
	//임시데이터 가져오기
	CrudVO selectCrud(CrudVO vo) throws Exception;
	
	//임시데이터 목록 가져오기
	List<EgovMap> selectCrudList(CrudVO vo) throws Exception;
	
	//임시데이터 등록
	//아직은 딱히 DB에서 받아오는 값이 없어서 void
	void insertCrud(CrudVO vo) throws Exception;
	
	//임시데이터 수정하기
	void updateCrud(CrudVO vo) throws Exception;
	
	//임시데이터 삭제하기
	void deleteCrud(CrudVO vo) throws Exception;
	
	//임시데이터 목록 수
	int selectCrudListCnt(CrudVO vo) throws Exception;

}
