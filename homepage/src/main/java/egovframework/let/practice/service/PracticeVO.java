package egovframework.let.practice.service;

import java.io.Serializable;
import java.util.Date;

import egovframework.com.cmm.ComDefaultVO;

public class PracticeVO extends ComDefaultVO implements Serializable {

	
	private String practiceId;
	
	private String practiceSb;
	
	private String practiceCon;
	
	private String practiceUser;
	
	private Date practiceTime;

	public String getPracticeId() {
		return practiceId;
	}

	public String getPracticeSb() {
		return practiceSb;
	}

	public String getPracticeCon() {
		return practiceCon;
	}

	public String getPracticeUser() {
		return practiceUser;
	}

	public Date getPracticeTime() {
		return practiceTime;
	}

	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	public void setPracticeSb(String practiceSb) {
		this.practiceSb = practiceSb;
	}

	public void setPracticeCon(String practiceCon) {
		this.practiceCon = practiceCon;
	}

	public void setPracticeUser(String practiceUser) {
		this.practiceUser = practiceUser;
	}

	public void setPracticeTime(Date practiceTime) {
		this.practiceTime = practiceTime;
	}

}