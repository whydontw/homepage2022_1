package egovframework.let.rsv.service;

import java.io.Serializable;

import egovframework.com.cmm.ComDefaultVO;

public class ReservationVO extends ComDefaultVO implements Serializable {
	
	
	//예약ID
	private String resveId;
	//예약구분코드
	private String resveSeCode;
	//예약제목
	private String resveSj;
	//강사명
	private String recNm;
	//최대참가인원
	private int maxAplyCnt;
	//운영시작일
	private String useBeginDt;
	//운영종료일
	private String useEndDt;
	//운영시작시간
	private String useBeginTime;
	//운영종료시간
	private String useEndTime;
	//내용
	private String resveCn;
	//신청기간시작일
	private String reqstBgnde;
	//신청기간종료일
	private String reqstEndde;
	//사용
	private String useAt;
	//최초등록시점
	private java.util.Date frstRegistPnttm;
	//최초등록자ID
	private String frstRegisterId;
	//최종수정시점
	private java.util.Date lastUpdtPnttm;
	//최종수정자ID
	private String lastUpdusrId;
	//사용자ID
	private String userId;
	//관리자 여부
	private String mngAt;
	//신청자
	private int applyCnt;
	//예약상태
	private String applyStatus;
	//승인된 신청자
	private int applyFCnt;
	public String getResveId() {
		return resveId;
	}
	public String getResveSeCode() {
		return resveSeCode;
	}
	public String getResveSj() {
		return resveSj;
	}
	public String getRecNm() {
		return recNm;
	}
	public int getMaxAplyCnt() {
		return maxAplyCnt;
	}
	public String getUseBeginDt() {
		return useBeginDt;
	}
	public String getUseEndDt() {
		return useEndDt;
	}
	public String getUseBeginTime() {
		return useBeginTime;
	}
	public String getUseEndTime() {
		return useEndTime;
	}
	public String getResveCn() {
		return resveCn;
	}
	public String getReqstBgnde() {
		return reqstBgnde;
	}
	public String getReqstEndde() {
		return reqstEndde;
	}
	public String getUseAt() {
		return useAt;
	}
	public java.util.Date getFrstRegistPnttm() {
		return frstRegistPnttm;
	}
	public String getFrstRegisterId() {
		return frstRegisterId;
	}
	public java.util.Date getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}
	public String getUserId() {
		return userId;
	}
	public String getMngAt() {
		return mngAt;
	}
	public int getApplyCnt() {
		return applyCnt;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public int getApplyFCnt() {
		return applyFCnt;
	}
	public void setResveId(String resveId) {
		this.resveId = resveId;
	}
	public void setResveSeCode(String resveSeCode) {
		this.resveSeCode = resveSeCode;
	}
	public void setResveSj(String resveSj) {
		this.resveSj = resveSj;
	}
	public void setRecNm(String recNm) {
		this.recNm = recNm;
	}
	public void setMaxAplyCnt(int maxAplyCnt) {
		this.maxAplyCnt = maxAplyCnt;
	}
	public void setUseBeginDt(String useBeginDt) {
		this.useBeginDt = useBeginDt;
	}
	public void setUseEndDt(String useEndDt) {
		this.useEndDt = useEndDt;
	}
	public void setUseBeginTime(String useBeginTime) {
		this.useBeginTime = useBeginTime;
	}
	public void setUseEndTime(String useEndTime) {
		this.useEndTime = useEndTime;
	}
	public void setResveCn(String resveCn) {
		this.resveCn = resveCn;
	}
	public void setReqstBgnde(String reqstBgnde) {
		this.reqstBgnde = reqstBgnde;
	}
	public void setReqstEndde(String reqstEndde) {
		this.reqstEndde = reqstEndde;
	}
	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}
	public void setFrstRegistPnttm(java.util.Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}
	public void setLastUpdtPnttm(java.util.Date lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setMngAt(String mngAt) {
		this.mngAt = mngAt;
	}
	public void setApplyCnt(int applyCnt) {
		this.applyCnt = applyCnt;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public void setApplyFCnt(int applyFCnt) {
		this.applyFCnt = applyFCnt;
	}
	
	
	
}
