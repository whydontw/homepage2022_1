package egovframework.let.crud2.service.impl;

import java.util.List;

import egovframework.let.crud2.service.Crud2Service;
import egovframework.let.crud2.service.Crud2VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("crud2Service") //controller와 연결
//어노테이션의 파일명의 첫글자는 소문자로 항상 시작한다
public class Crud2ServiceImpl extends EgovAbstractServiceImpl implements Crud2Service {

	@Resource(name = "crud2Mapper")
	private Crud2Mapper crud2Mapper;
	
	@Resource(name = "egovCrudIdGnrService")
	private EgovIdGnrService idgenService;	
	
	
	@Override
	public Crud2VO selectCrud(Crud2VO vo) throws Exception {
		return crud2Mapper.selectCrud(vo);
	}
	
	//CRUD 목록 가져오기
	@Override
	public List<EgovMap> selectCrudList(Crud2VO vo) throws Exception {
		return crud2Mapper.selectCrudList(vo);
	}
	
	//임시데이터 등록하기
	//tempMapper.insertTemp(vo)의 값이 void인데 우리는 string값으로 받아와야하기 때문에 return값이 null
	@Override
	public String insertCrud(Crud2VO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setCrudId(id);
		crud2Mapper.insertCrud(vo);
		return id;
	}
	
	//임시데이터 수정하기
	@Override
	public void updateCrud(Crud2VO vo) throws Exception{
		crud2Mapper.updateCrud(vo);
	}
	
	//임시데이터 삭제하기
	@Override
	public void deleteCrud(Crud2VO vo) throws Exception{
		crud2Mapper.deleteCrud(vo);
	}
	
	//임시데이터 목록 수
	@Override
	public int selectCrudListCnt(Crud2VO vo) throws Exception{
		return crud2Mapper.selectCrudListCnt(vo);
	}

}
