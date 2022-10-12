package egovframework.let.rsv.service.impl;

import java.util.List;

import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("reservationApplyMapper")
public interface ReservationApplyMapper {

	//예약가능 여부 확인
	//void rsvCheck(ReservationApplyVO vo) throws Exception;
	
	//기존신청 여부
	int duplicateApplyCheck(ReservationApplyVO vo) throws Exception;

	//예약자 상세 정보
	ReservationApplyVO selectReservationApply(ReservationApplyVO vo) throws Exception;

	//예약자 등록하기
	void insertReservationApply(ReservationApplyVO vo) throws Exception;

	List<EgovMap> selectReservationApplyList(ReservationApplyVO vo) throws Exception;

	int selectReservationApplyListCnt(ReservationApplyVO vo) throws Exception;

	//예약자 수정하기
	void updateReservationApply(ReservationApplyVO vo) throws Exception;

	//예약자 삭제하기
	void deleteReservationApply(ReservationApplyVO vo) throws Exception;

	//예약자 승인처리
	void updateReservationConfirm(ReservationApplyVO vo) throws Exception;

}
