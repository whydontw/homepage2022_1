package egovframework.com.cmm.service;

import java.io.Serializable;

public class JsonResponse implements Serializable{
	
	//22.10.17 엑셀파일 업로드
	
	//성공여부
	private boolean success = false;
	
	//권한에러
	private boolean auth = false;
	
	//에러 코드
	private String code;
	
	//에러 메시지
	private String message;
	
	private Serializable data;
	private Serializable files;
	private Serializable wireData;
	
	private int count = 0;
	
	public JsonResponse() {}
	
	public JsonResponse(boolean success) {
		this.success = success;
	}

	public JsonResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public JsonResponse(boolean success, String code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}
	
	
	
	
	
	//Getter & Setter 구간
	
	public boolean isSuccess() {
		return success;
	}

	public boolean isAuth() {
		return auth;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Serializable getData() {
		return data;
	}

	public Serializable getFiles() {
		return files;
	}

	public Serializable getWireData() {
		return wireData;
	}

	public int getCount() {
		return count;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

	public void setFiles(Serializable files) {
		this.files = files;
	}

	public void setWireData(Serializable wireData) {
		this.wireData = wireData;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
