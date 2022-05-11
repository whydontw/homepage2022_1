package egovframework.let.crud.service;

import java.util.List;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface CrudService {
	//임시데이터 가져오기
	public CrudVO selectCrud(CrudVO vo) throws Exception;
	
	//임시데이터 목록 가져오기: controller에서 필요
	public List<EgovMap> selectCrudList(CrudVO vo) throws Exception;
	
	//임시데이터 가져오기
	public String insertCrud(CrudVO vo) throws Exception;
	
	//임시데이터 수정하기
	public void updateCrud(CrudVO vo) throws Exception;
	
	//임시데이터 삭제하기
	public void deleteCrud(CrudVO vo) throws Exception;
	
	//임시데이터 목록 수: controller에서 필요
	public int selectCrudListCnt(CrudVO vo) throws Exception;
	
}