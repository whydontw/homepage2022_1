package egovframework.let.board.service;

import java.io.Serializable;
import java.util.Date;

import egovframework.com.cmm.ComDefaultVO;

public class BoardVO extends ComDefaultVO implements Serializable {
	
	//게시판 ID
	private String boardId;
	
	//게시물 제목
	private String boardSj;
	
	//게시물 내용
	private String boardCn;
	
	//조회수
	private int inquireCo;
	
	//등록자IP
	private String creatIp;
	
	//공개여부
	private String noticeAt;
	
	//비공개여부
	private String othbcAt;
	
	//사용여부
	private String useAt;
	
	//첨부파일아이디
	private String atchFileId;
	
	//최초등록시점
	private Date frstRegistPnttm;
	
	//최초등록자아이디
	private String frstRegisterId;
	
	//최종수정시점
	private Date lastUpdtPnttm;
	
	//최종수정자아이디
	private String lastUpdusrId;
	
	//사용자아이디
	private String userId;
	
	//관리자여부
	private String mngAt;

	public String getBoardId() {
		return boardId;
	}

	public String getBoardSj() {
		return boardSj;
	}

	public String getBoardCn() {
		return boardCn;
	}

	public int getInquireCo() {
		return inquireCo;
	}

	public String getCreatIp() {
		return creatIp;
	}

	public String getNoticeAt() {
		return noticeAt;
	}

	public String getOthbcAt() {
		return othbcAt;
	}

	public String getUseAt() {
		return useAt;
	}

	public String getAtchFileId() {
		return atchFileId;
	}

	public Date getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	public Date getLastUpdtPnttm() {
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

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public void setBoardSj(String boardSj) {
		this.boardSj = boardSj;
	}

	public void setBoardCn(String boardCn) {
		this.boardCn = boardCn;
	}

	public void setInquireCo(int inquireCo) {
		this.inquireCo = inquireCo;
	}

	public void setCreatIp(String creatIp) {
		this.creatIp = creatIp;
	}

	public void setNoticeAt(String noticeAt) {
		this.noticeAt = noticeAt;
	}

	public void setOthbcAt(String othbcAt) {
		this.othbcAt = othbcAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public void setFrstRegistPnttm(Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public void setLastUpdtPnttm(Date lastUpdtPnttm) {
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
}
