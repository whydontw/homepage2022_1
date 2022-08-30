package egovframework.let.Join.service.impl;

import egovframework.let.Join.service.JoinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;


@Mapper("joinMapper")
public interface JoinMapper {
	
	//회원등록
	public void insertJoin(JoinVO vo) throws Exception;
	
	//ID 중복 체크
	int duplicateCheck(JoinVO vo) throws Exception;

}
