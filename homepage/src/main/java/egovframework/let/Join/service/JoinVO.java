package egovframework.let.Join.service;

import java.io.Serializable;
import java.util.Date;

import egovframework.com.cmm.ComDefaultVO;

public class JoinVO extends ComDefaultVO implements Serializable {

//	아이디
	private String emplyrId;
//	이름
	private String userNm;
//	비밀번호
	private String password;
//	비밀번호 힌트
	private String passwordHint;
//	비밀번호 정답
	private String passwordCnsr;
//	사용자상태코드
	private String emplyrSttusCode;
//	회원고유ID
	private String esntlId;
//	로그인타입
	private String loginType;
//	가입일자
	private Date sbscrbDe;
	
	
	public String getEmplyrId() {
		return emplyrId;
	}
	public String getUserNm() {
		return userNm;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public String getPasswordCnsr() {
		return passwordCnsr;
	}
	public String getEmplyrSttusCode() {
		return emplyrSttusCode;
	}
	public String getEsntlId() {
		return esntlId;
	}
	public String getLoginType() {
		return loginType;
	}
	public Date getSbscrbDe() {
		return sbscrbDe;
	}
	public void setEmplyrId(String emplyrId) {
		this.emplyrId = emplyrId;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public void setPasswordCnsr(String passwordCnsr) {
		this.passwordCnsr = passwordCnsr;
	}
	public void setEmplyrSttusCode(String emplyrSttusCode) {
		this.emplyrSttusCode = emplyrSttusCode;
	}
	public void setEsntlId(String esntlId) {
		this.esntlId = esntlId;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public void setSbscrbDe(Date sbscrbDe) {
		this.sbscrbDe = sbscrbDe;
	}
	
}