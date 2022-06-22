package egovframework.let.board.web;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.fcc.service.FileMngUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "EgovFileMngService")
	private EgovFileMngService fileMngService;
	
	@Resource(name = "fileMngUtil")
	private FileMngUtil fileUtil;	

	// 임시데이터 목록 가져오기
	@RequestMapping(value = "/board/selectList.do")
	public String selectList(@ModelAttribute("searchVO") BoardVO searchVO, HttpServletRequest request, ModelMap model)
			throws Exception {

		// 공지게시글
		// 공지 + 일반글 ==> 하나의 게시판
		searchVO.setNoticeAt("Y");
		List<EgovMap> noticeResultList = boardService.selectBoardList(searchVO);
		model.addAttribute("noticeResultList", noticeResultList);

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		searchVO.setNoticeAt("N");	//공지가 두번 나오지 않게끔 브레이크를 걸어주는 거
		List<EgovMap> resultList = boardService.selectBoardList(searchVO);
		model.addAttribute("resultList", resultList);

		// total count를 가지고 오는 쿼리
		int totCnt = boardService.selectBoardListCnt(searchVO);

		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);	//사용자 정보 저장

		return "board/BoardSelectList";
	}

	// 게시물 등록/수정을 위한 폼을 호출
	@RequestMapping(value = "/board/boardRegist.do")
	public String boardRegist(@ModelAttribute("searchVO") BoardVO BoardVO, HttpServletRequest request, ModelMap model)
			throws Exception {

		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser(); // 로그인 정보 가져오기, 세션 가져오기
		if (user == null || user.getId() == null) { // '로그인을 해야만이 사용가능하다'라는 뜻으로 만든 로직
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "forward:/board/selectList.do";
		} else {
			model.addAttribute("USER_INFO", user); // 로그인 정보가 있을 경우
		}

		BoardVO result = new BoardVO();
		if (!EgovStringUtil.isEmpty(BoardVO.getBoardId())) {
			result = boardService.selectBoard(BoardVO);
			//본인 및 관리자만 허용
			//본인과 관리자만 수정할 수 있는 비밀글, 다른 사람들은 접근할 수 없음
			if(!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId())) {
				model.addAttribute("message", "작성자 본인만 확인이 가능합니다.");
				return "forward:/board/selectList.do";		
			}
		}
		model.addAttribute("result", result);
		request.getSession().removeAttribute("sessionBoard");

		return "board/BoardRegist";
	}

	// 게시물 등록
	@RequestMapping(value = "/board/insert.do")
	public String insert(final MultipartHttpServletRequest multiRequest, @ModelAttribute("searchVO") BoardVO searchVO, HttpServletRequest request, ModelMap model)
			throws Exception {	//final을 이용해 불변값으로 만드는 이유: 올리다가 중간에 가로채져서 해킹파일로 바뀌지 않기 위해서

		// 이중 서브밋 방지 체크
		if (request.getSession().getAttribute("sessionBoard") != null) {
			return "forward:/board/selectList.do";
		}

		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "forward:/board/selectList.do";
		}
		
		//-------- 22.06.15 첨부파일 파일 업로드 ---------------

		List<FileVO> result = null;
		String atchFileId = "";
		
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		if(!files.isEmpty()) {
			result = fileUtil.parseFileInf(files, "BOARD_", 0, "", "board.fileStorePath");
//			^업로드된 파일 지정파일에 저장
//			확장자가 없는 이유: 보안
			atchFileId = fileMngService.insertFileInfs(result);
		}
		
		//-----------------------------------------------
		searchVO.setAtchFileId(atchFileId);
		searchVO.setCreatIp(request.getRemoteAddr()); // 공인 아이피가 저장됨
		searchVO.setUserId(user.getId());

		boardService.insertBoard(searchVO);

		// 이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", searchVO);
		return "forward:/board/selectList.do"; // 첫페이지로 이동시켜줌
	}
	
	//게시물 가져오기
	@RequestMapping(value = "/board/select.do")
	public String select(@ModelAttribute("searchVO") BoardVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		BoardVO result = boardService.selectBoard(searchVO);
		
		//비밀글여부 체크
		if("Y".equals(result.getOthbcAt())) {	//==비밀글일 경우
			//본인 및 관리자만 허용
			if(user == null || user.getId() == null || (!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId()))) {
				model.addAttribute("message", "작성자 본인만 확인 가능합니다");
				return "forward:/board/selectList.do";
			}	
		}
		model.addAttribute("result", result);
		
		return "board/BoardSelect";
	}
	
	//게시물 수정하기
	@RequestMapping(value = "/board/update.do")
	public String update(final MultipartHttpServletRequest multiRequest, @ModelAttribute("searchVO") BoardVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		//이중서브밋 방지
		if(request.getSession().getAttribute("sessionBoard") != null) {
			return "forward:/board/selectList.do";
		}
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "forward:/board/selectList.do";
		}else if("admin".equals(user.getId())) {
			searchVO.setMngAt("Y");
		}
		
		String atchFileId = searchVO.getAtchFileId();
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		if(!files.isEmpty()) {
			if(EgovStringUtil.isEmpty(atchFileId)) {
				//'0' 첨부파일 개수 첫번째 카운트, ""
				List<FileVO> result = fileUtil.parseFileInf(files, "BOARD_", 0, "", "board.fileStorePath");
				atchFileId = fileMngService.insertFileInfs(result);
				searchVO.setAtchFileId(atchFileId);
			}else {
				FileVO fvo = new FileVO();
				fvo.setAtchFileId(atchFileId);
				int cnt = fileMngService.getMaxFileSN(fvo);
				List<FileVO> _result = fileUtil.parseFileInf(files, "BOARD_", cnt, atchFileId, "board.fileStorePath");
				fileMngService.updateFileInfs(_result);
			}
		}	
		
		searchVO.setUserId(user.getId());
		
		boardService.updateBoard(searchVO);
		
		//이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", searchVO);
		return "forward:/board/selectList.do";
	}
	
	//게시물 삭제하기
	@RequestMapping(value = "/board/delete.do")
	public String delete(@ModelAttribute("searchVO") BoardVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "forward:/board/selectList.do";
		}else if("admin".equals(user.getId())) {
			searchVO.setMngAt("Y");
		}
		
		searchVO.setUserId(user.getId());
		boardService.deleteBoard(searchVO);
		
		return "forward:/board/selectList.do";
	}
	
}
