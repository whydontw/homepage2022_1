package egovframework.let.rsv.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface ReservationApplyService {

	public ReservationApplyVO rsvCheck(ReservationApplyVO vo) throws Exception;

	public ReservationApplyVO selectReservationApply(ReservationApplyVO vo) throws Exception;

	public ReservationApplyVO insertReservationApply(ReservationApplyVO vo) throws Exception;

	public List<EgovMap> selectReservationApplyList(ReservationApplyVO vo) throws Exception;

	public int selectReservationApplyListCnt(ReservationApplyVO vo) throws Exception;

	//예약자 수정
	public void updateReservationApply(ReservationApplyVO vo) throws Exception;
	
	//예약자 승인처리
	public void updateReservationConfirm(ReservationApplyVO vo) throws Exception;

	//예약자 삭제하기
	public void deleteReservationApply(ReservationApplyVO vo) throws Exception;
}
