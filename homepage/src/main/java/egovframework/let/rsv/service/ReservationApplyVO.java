package egovframework.let.rsv.service;

import java.io.Serializable;

import egovframework.com.cmm.ComDefaultVO;

public class ReservationApplyVO extends ReservationVO implements Serializable {
	
	//예약아이디
	private String resveId;
	//예약자아이디
	private String reqstId;
	//신청구분코드
	private String resveDe;
	//신청자명
	private String chargerNm;
	//연락처
	private String telno;
	//이메일
	private String email;
	
	/* R:접수 / O: 승인완료 / X: 반려  */

	private String confmSeCode;
	//승인자ID
	private String confmerId;
	//반려사유
	private String returnResn;
	//승인일자
	private java.util.Date confmPnttm;
	//등록 ip
	private String creatIp;
	//사용여부
	private String useAt;
	//최초등록시점
	private java.util.Date frstRegistPnttm;
	
	//최초등록자아이디
	private String frstRegisterId;
	//최종수정시점
	private java.util.Date lastUpdtPnttm;
	//최종수정자아이디
	private String lastUpdusrId;
	//사용자아이디
	private String userId;
	//관리자여부
	private String mngAt;
	
	//에러코드
	private String errorCode;
	//메시지
	private String message;
	//엑셀여부
	private String excelAt;
	//임시예약자
	private String reqsttempId;
	public String getResveId() {
		return resveId;
	}
	public String getReqstId() {
		return reqstId;
	}
	public String getResveDe() {
		return resveDe;
	}
	public String getChargerNm() {
		return chargerNm;
	}
	public String getTelno() {
		return telno;
	}
	public String getEmail() {
		return email;
	}
	public String getConfmSeCode() {
		return confmSeCode;
	}
	public String getConfmerId() {
		return confmerId;
	}
	public String getReturnResn() {
		return returnResn;
	}
	public java.util.Date getConfmPnttm() {
		return confmPnttm;
	}
	public String getCreatIp() {
		return creatIp;
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
	public String getErrorCode() {
		return errorCode;
	}
	public String getMessage() {
		return message;
	}
	public String getExcelAt() {
		return excelAt;
	}
	public String getReqsttempId() {
		return reqsttempId;
	}
	public void setResveId(String resveId) {
		this.resveId = resveId;
	}
	public void setReqstId(String reqstId) {
		this.reqstId = reqstId;
	}
	public void setResveDe(String resveDe) {
		this.resveDe = resveDe;
	}
	public void setChargerNm(String chargerNm) {
		this.chargerNm = chargerNm;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setConfmSeCode(String confmSeCode) {
		this.confmSeCode = confmSeCode;
	}
	public void setConfmerId(String confmerId) {
		this.confmerId = confmerId;
	}
	public void setReturnResn(String returnResn) {
		this.returnResn = returnResn;
	}
	public void setConfmPnttm(java.util.Date confmPnttm) {
		this.confmPnttm = confmPnttm;
	}
	public void setCreatIp(String creatIp) {
		this.creatIp = creatIp;
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
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setExcelAt(String excelAt) {
		this.excelAt = excelAt;
	}
	public void setReqsttempId(String reqsttempId) {
		this.reqsttempId = reqsttempId;
	}
	
	
}
