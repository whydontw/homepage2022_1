package egovframework.let.admin.rsv.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.service.JsonResponse;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.rsv.service.ReservationApplyService;
import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.let.rsv.service.ReservationService;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class ReservationAdminApplyController {
	

	@Resource(name = "reservationApplyService")
	private ReservationApplyService reservationApplyService;
	
	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;
	
	
	//예약자정보 목록 가져오기
	@RequestMapping(value = "/admin/rsv/selectApplyList.do")
	public String selectApplyList(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "redirect:/mainpage.do";
		}
		
		
		//관리자
		searchVO.setMngAt("Y");
		
		List<EgovMap> resultList = reservationApplyService.selectReservationApplyList(searchVO);
		model.addAttribute("resultList", resultList);
		
		//22.10.17 엑셀 다운로드
		if("Y".equals(searchVO.getExcelAt())) {
			return "admin/rsv/RsvApplySelectListExcel";
		}
		return "admin/rsv/RsvApplySelectList";
	}
	
	
	//예약자 정보 상세
	@RequestMapping(value = "/admin/rsv/rsvApplySelect.do")
	public String rsvApplySelect(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "redirect:/mainpage.do";
		}else {
			model.addAttribute("USER_INFO", user);
		}
		
		ReservationApplyVO result = reservationApplyService.selectReservationApply(searchVO);
		
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionReservationApply");
		
		return "admin/rsv/RsvApplySelect";
		}
	
	//예약정보 승인
	@RequestMapping(value = "/admin/rsv/rsvApplyConfirm.do")
	public String rsvApplyConfirm(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		//이중 서브밋 방지
		if(request.getSession().getAttribute("sessionReservationApply") != null) {
			return "forward:/admin/rsv/selectApplyList.do";
		}
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "redirect:/mainpage.do";
		}
		searchVO.setUserId(user.getId());
		
		reservationApplyService.updateReservationConfirm(searchVO);
		
		//이중 서브밋 방지
		request.getSession().setAttribute("sessionReservationApply", searchVO);
		return "forward:/admin/rsv/selectApplyList.do";
	}
	
	//예약정보 삭제하기
	@RequestMapping(value = "/admin/rsv/rsvApplyDelete.do")
	public String rsvApplyDelete(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용 가능합니다.");
			return "forward:/mainpage.do";
		}
		
		searchVO.setUserId(user.getId());
		
		reservationApplyService.deleteReservationApply(searchVO);
		
		return "forward:/admin/rsv/selectApplyList.do";
	}
	
	
	
	//예약자 엑셀 다운로드
	@RequestMapping(value = "/admin/rsv/excel.do")
	public ModelAndView excel(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> columMap = new ArrayList<String>();
		List<Object> valueMap = new ArrayList<Object>();
		String fileName = "";
		
		columMap.add("번호");
		columMap.add("신청자명");
		columMap.add("연락처");
		columMap.add("이메일");
		columMap.add("신청일");
		
		map.put("title", "예약신청현황");
		fileName = EgovStringUtil.getConvertFileName(request, "예약신청현황");
	
		//관리자
		searchVO.setMngAt("Y");
		
		//목록
		List<EgovMap> resultList = reservationApplyService.selectReservationApplyList(searchVO);
		
		if(resultList != null) {
			EgovMap tmpVO = null;
			Map<String, Object> tmpMap = null;
			for(int i = 0; i < resultList.size(); i++) {
				tmpVO = resultList.get(i);
				
				tmpMap = new HashMap<String, Object>();

				// ******* 위의 컬럼명 순서와 동일하게 *******
				tmpMap.put("번호", i + 1);
				tmpMap.put("신청자명", tmpVO.get("chargerNm").toString() + "(" + tmpVO.get("frstRegisterId").toString() + ")");
				tmpMap.put("연락처", tmpVO.get("telno").toString());
				tmpMap.put("이메일", tmpVO.get("email").toString());
				tmpMap.put("신청일", tmpVO.get("frstRegistPnttmYmd").toString());
				
				valueMap.add(tmpMap);
			}
		}
		
		
		map.put("columMap", columMap); //thead 컬럼명
		map.put("valueMap", valueMap); //tbody에 들어가는 데이터 값
		
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
		
		return new ModelAndView("excelDownloadView", "dataMap", map);
		
	}
	
	//엑셀업로드
	@RequestMapping(value = "/admin/rsv/excelUpload.json", method = RequestMethod.POST) //첨부파일은 post로 보내야한다
	public @ResponseBody JsonResponse excelUpload(@ModelAttribute ReservationApplyVO searchVO,
			ModelMap model, MultipartHttpServletRequest multiRequest, HttpServletRequest request, //MultipartHttpServletRequest: 첨부파일 받아줌
			HttpServletResponse response) throws Exception {
		
		JsonResponse res = new JsonResponse();
		res.setSuccess(true); //에러시 false
		
		
		try {
			List<FileVO> result = null;
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			if(!files.isEmpty()) {											//storePath
				result = fileUtil.parseFileInf(files, "TEMP_", 0, null, "rsvFileStorePath"); //excel 파일을 저장하는 방식
				Map<String, Object> resultMap = new HashMap<>();
				
				for(FileVO file : result) {
					if("xls".equals(file.getFileExtsn()) || "xlsx".equals(file.getFileExtsn())) {
						searchVO.setCreatIp(request.getRemoteAddr());
						resultMap = reservationApplyService.excelUpload(file, searchVO);
						if(!(Boolean)resultMap.get("success")) {
							res.setMessage(String.valueOf(resultMap.get("msg")));
							ArrayList resultList = (ArrayList) resultMap.get("resultList");
							res.setData(resultList);
							res.setSuccess(false);
						}
					}
				}
			}
				
		} catch (DataAccessException e) {
			res.setMessage(e.getLocalizedMessage());
		}
		return res;
	}
}