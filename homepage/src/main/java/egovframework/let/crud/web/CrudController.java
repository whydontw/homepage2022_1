package egovframework.let.crud.web;
import java.util.List;

import egovframework.let.crud.service.CrudService;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CrudController {

	@Resource(name = "crudService")
	private CrudService crudService;
	
	//임시데이터 가져오기
	@RequestMapping(value = "/crud/select.do")
	public String select(@ModelAttribute("searchVO") CrudVO searchVO,	//searchVO가 CrudVO를 불러오게끔
			HttpServletRequest request, ModelMap model) throws Exception{
		
		CrudVO result = crudService.selectCrud(searchVO);
		model.addAttribute("result", result);
		return "crud/CrudSelect";
	}
	
	//임시데이터 목록 가져오기
	@RequestMapping(value = "/crud/selectList.do")
	public String selectList(@ModelAttribute("searchVO") CrudVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		
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
		int totCnt = crudService.selectCrudListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		//------
		
		//List를 가지고 오는 쿼리
		List<EgovMap> resultList = crudService.selectCrudList(searchVO);
		model.addAttribute("resultList", resultList);
		
		return "crud/CrudSelectList";
	}
	
	//CRUD 등록/수정
	@RequestMapping(value="/crud/crudRegist.do")
	public String crudRegist(@ModelAttribute("searchVO") CrudVO crudVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		// 등록과 수정을 나누기 위하여 변수 result 선언이랑 if~model.을 넣어주는 거야
		CrudVO result = new CrudVO();
		if(!EgovStringUtil.isEmpty(crudVO.getCrudId())) {
			result=crudService.selectCrud(crudVO);
		}
		model.addAttribute("result",result);
		
		return "crud/CrudRegist";
		}
	
	//임시데이터 등록하기
	@RequestMapping(value="/crud/insert.do")
	public String insert(@ModelAttribute("searchVO") CrudVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		crudService.insertCrud(searchVO);
		return "forward:/crud/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value="/crud/update.do")
	public String update(@ModelAttribute("searchVO") CrudVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		crudService.updateCrud(searchVO);
		return "forward:/crud/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value="/crud/delete.do")
	public String delete(@ModelAttribute("searchVO") CrudVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		crudService.deleteCrud(searchVO);
		return "forward:/crud/selectList.do";
	}
	}

