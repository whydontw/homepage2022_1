package egovframework.let.crud.service;

import java.io.Serializable;
import java.util.Date;

import egovframework.com.cmm.ComDefaultVO;

public class CrudVO extends ComDefaultVO implements Serializable {

	
	private String crudId;
	
	private String crudSj;
	
	private String crudCn;
	
	private String userNm;
	
	private Date frstRegistPnttm;

	public String getCrudId() {
		return crudId;
	}

	public String getCrudSj() {
		return crudSj;
	}

	public String getCrudCn() {
		return crudCn;
	}

	public String getUserNm() {
		return userNm;
	}

	public Date getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setCrudId(String crudId) {
		this.crudId = crudId;
	}

	public void setCrudSj(String crudSj) {
		this.crudSj = crudSj;
	}

	public void setCrudCn(String crudCn) {
		this.crudCn = crudCn;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public void setFrstRegistPnttm(java.util.Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}
}
