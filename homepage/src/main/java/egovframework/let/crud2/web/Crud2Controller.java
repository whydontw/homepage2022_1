package egovframework.let.crud2.web;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.crud2.service.Crud2Service;
import egovframework.let.crud2.service.Crud2VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class Crud2Controller {

	@Resource(name = "crud2Service") //impl에서 연결
	private Crud2Service crud2Service;
	
	//임시데이터 가져오기
	@RequestMapping(value = "/crud2/select.do")
	public String select(@ModelAttribute("searchVO") Crud2VO searchVO,	//searchVO가 CrudVO를 불러오게끔
			HttpServletRequest request, ModelMap model) throws Exception{
		
		Crud2VO result = crud2Service.selectCrud(searchVO);
		model.addAttribute("result", result);
		return "crud2/Crud2Select";
	}
	
	//임시데이터 목록 가져오기
	@RequestMapping(value = "/crud2/selectList.do") //uri 입력
	public String selectList(@ModelAttribute("searchVO") Crud2VO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		
		//------ 22-04-20 ------
		//page를 만들기 위해서 CrudSelectList.jsp에서 <c:pagnation>을 이용하는 거, 그거 불러오는 것
		//수정 없이 그대로 가져다가 써도 되는 부분
		
		PaginationInfo paginationInfo = new PaginationInfo();
		//PagnationInfo ctrl 누르고 링크 타고 가면 Required Fields에 정보가 나온다
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//total count를 가지고 오는 쿼리
		int totCnt = crud2Service.selectCrudListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		//------
		
		//List를 가지고 오는 쿼리
		List<EgovMap> resultList = crud2Service.selectCrudList(searchVO);
		model.addAttribute("resultList", resultList);
		
		return "crud2/Crud2SelectList"; // jsp
	}
	
	//CRUD 등록/수정
	@RequestMapping(value="/crud2/crudRegist.do")
	public String crudRegist(@ModelAttribute("searchVO") Crud2VO crud2VO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		// 등록과 수정을 나누기 위하여 변수 result 선언이랑 if~model.을 넣어주는 거야
		Crud2VO result = new Crud2VO();
		if(!EgovStringUtil.isEmpty(crud2VO.getCrudId())) {
			result=crud2Service.selectCrud(crud2VO);
		}
		model.addAttribute("result",result);
		
		return "crud2/Crud2Regist";
		}
	
	//임시데이터 등록하기
	@RequestMapping(value="/crud2/insert.do")
	public String insert(@ModelAttribute("searchVO") Crud2VO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		crud2Service.insertCrud(searchVO);
		return "forward:/crud2/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value="/crud2/update.do")
	public String update(@ModelAttribute("searchVO") Crud2VO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		crud2Service.updateCrud(searchVO);
		return "forward:/crud2/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value="/crud2/delete.do")
	public String delete(@ModelAttribute("searchVO") Crud2VO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		crud2Service.deleteCrud(searchVO);
		return "forward:/crud2/selectList.do";
	}
	}

