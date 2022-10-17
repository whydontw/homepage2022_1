package egovframework.let.rsv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.rsv.service.ReservationApplyService;
import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.let.rsv.service.ReservationService;
import egovframework.let.rsv.service.ReservationVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("reservationApplyService")
public class ReservationApplyServiceImpl extends EgovAbstractServiceImpl implements ReservationApplyService {

	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "reservationApplyMapper")
	private ReservationApplyMapper reservationApplyMapper;

	
	@Resource(name = "egovRsvIdGnrService")
	private EgovIdGnrService idgenService;
	
	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	@Resource(name = "egovReqTempIdGnrService")
	private EgovIdGnrService idgenTempService;

	
	//예약가능 여부 확인
	@Override
	public ReservationApplyVO rsvCheck(ReservationApplyVO vo) throws Exception {

		//신청인원 체크
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setResveId(vo.getResveId());
		ReservationVO result = reservationService.selectReservation(reservationVO);
		
		if(result.getMaxAplyCnt() <= result.getApplyCnt()) { //getMaxAplyCnt 받을 수 있는 수보다 getApplyCnt 받는 수가 많다면
			vo.setErrorCode("ERROR-R1");
			vo.setMessage("마감되었습니다.");
		}else if(reservationApplyMapper.duplicateApplyCheck(vo) > 0) {
			vo.setErrorCode("ERROR-R2");
			vo.setMessage("이미 해당 프로그램에 예약이 되어있습니다.");
		}
		return vo;
	}

	//예약자 상세 정보
	@Override
	public ReservationApplyVO selectReservationApply(ReservationApplyVO vo) throws Exception {
		return reservationApplyMapper.selectReservationApply(vo);
	}

	//예약자 등록하기
	@Override
	public ReservationApplyVO insertReservationApply(ReservationApplyVO vo) throws Exception {
		// 신청 인원 체크
		
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setResveId(vo.getResveId());
		ReservationVO result = reservationService.selectReservation(reservationVO);
		if(result.getMaxAplyCnt() <= result.getApplyFCnt()) {
			vo.setErrorCode("ERROR-R1");
			vo.setMessage("마감되었습니다.");
		}else {
			//기존 신청여부
			if(reservationApplyMapper.duplicateApplyCheck(vo) > 0) {
				vo.setErrorCode("ERROR-R2");
				vo.setMessage("이미 해당 프로그램에 예약이 되어있습니다.");
			}else {
				String id = idgenService.getNextStringId();
				vo.setReqstId(id);
				reservationApplyMapper.insertReservationApply(vo);
			}
		}
		
		return vo;
	}

	@Override
	public List<EgovMap> selectReservationApplyList(ReservationApplyVO vo) throws Exception {
		return reservationApplyMapper.selectReservationApplyList(vo);
	}

	@Override
	public int selectReservationApplyListCnt(ReservationApplyVO vo) throws Exception {
		return reservationApplyMapper.selectReservationApplyListCnt(vo);
	}

	@Override
	public void updateReservationApply(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.updateReservationApply(vo);
		
	}

	@Override
	public void deleteReservationApply(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.deleteReservationApply(vo);
	}
	
	@Override
	public void updateReservationConfirm(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.updateReservationConfirm(vo);
	}
	
	
	
}
