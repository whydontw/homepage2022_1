package egovframework.let.temp.web;
import java.util.List;
import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
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
public class TempController {

	@Resource(name = "tempService")
	private TempService tempService;
	
	//임시데이터 가져오기
	@RequestMapping(value = "/temp/select.do")
	public String select(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		TempVO result = tempService.selectTemp(searchVO);
		model.addAttribute("result", result);
		return "temp/TempSelect";
	}
	
	//임시데이터 목록 가져오기
	@RequestMapping(value = "/temp/selectList.do")
	public String selectList(@ModelAttribute("searchVO") TempVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		
		//------ 22-04-20 ------
		
		PaginationInfo paginationInfo = new PaginationInfo();
		//PagnationInfo ctrl 누르고 링크 타고 가면 Required Fields에 정보가 나온다
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		int totCnt = tempService.selectTempListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		//------
		
		List<EgovMap> resultList = tempService.selectTempList(searchVO);
		model.addAttribute("resultList", resultList);
		
		return "temp/TempSelectList";
	}
	
	//임시데이터 등록/수정
	@RequestMapping(value="/temp/tempRegist.do")
	public String tempRegist(@ModelAttribute("searchVO") TempVO tempVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		TempVO result = new TempVO();
		if(!EgovStringUtil.isEmpty(tempVO.getTempId())) {
			result=tempService.selectTemp(tempVO);
		}
		model.addAttribute("result",result);
		
		return "temp/TempRegist";
		}
	
	//임시데이터 등록하기
	@RequestMapping(value="/temp/insert.do")
	public String insert(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		tempService.insertTemp(searchVO);
		return "forward:/temp/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value="/temp/update.do")
	public String update(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		tempService.updateTemp(searchVO);
		return "forward:/temp/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value="/temp/delete.do")
	public String delete(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		
		tempService.deleteTemp(searchVO);
		return "forward:/temp/selectList.do";
	}
	
	//JSTL
	@RequestMapping(value="/temp/jstl.do")
	public String jstl(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		return "/temp/Jstl";
	}
	
	//JSTL Import@
	@RequestMapping(value="/temp/jstlImport.do")
	public String jstlImport(@ModelAttribute("searchVO") TempVO searchVO,
			HttpServletRequest request, ModelMap model) throws Exception{
		return "/temp/JstlImport";
	}
}
