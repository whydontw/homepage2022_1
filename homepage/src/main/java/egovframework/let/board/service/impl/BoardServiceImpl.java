package egovframework.let.board.service.impl;

import java.util.List;

import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")	//하나의 프로젝트별 하나씩
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

	@Resource(name = "boardMapper")
	private BoardMapper boardMapper;
	
	@Resource(name = "egovBoardIdGnrService")
	private EgovIdGnrService idgenService;
	
	//게시물 목록 가져오기
	@Override
	public List<EgovMap> selectBoardList(BoardVO vo) throws Exception{
		return boardMapper.selectBoardList(vo);
	}
	
	//게시물 목록 수
	@Override
	public int selectBoardListCnt(BoardVO vo) throws Exception{
		return boardMapper.selectBoardListCnt(vo);
	}
	
	//게시물 등록
	@Override
	public String insertBoard(BoardVO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setBoardId(id);
		boardMapper.insertBoard(vo);
		
		return id;
	}
	
	//게시물 상세 정보
	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception{
		//조회수 업
		//impl(트랜젝션)에서 작성해야함
		//이유: 도중에 에러가 났을 때 카운트가 되지 않아야함(=rollback되어야)
		boardMapper.updateViewCnt(vo);
		return boardMapper.selectBoard(vo);		
	}
	
	//게시물 수정하기
	@Override
	public void updateBoard(BoardVO vo) throws Exception{
		boardMapper.updateBoard(vo);
	}
	
	//게시물 삭제하기
	@Override
	public void deleteBoard(BoardVO vo) throws Exception{
		boardMapper.deleteBoard(vo);
	}
}