package egovframework.let.member.service;

import java.io.Serializable;
import egovframework.com.cmm.ComDefaultVO;

public class MemberVO extends ComDefaultVO implements Serializable {

	private String memId;

	private String memPass;

	private String memName;

	private String memEmail;

	private String memPhone;

	private int memAge;

	
	public String getMemId() {
		return memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public String getMemName() {
		return memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public int getMemAge() {
		return memAge;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public void setMemAge(int memAge) {
		this.memAge = memAge;
	}

}