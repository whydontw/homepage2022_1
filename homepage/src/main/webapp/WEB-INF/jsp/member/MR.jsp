<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>회원가입</title>
<style>
</style>
</head>
<body>

	<form action="/member/add.do" method="post">
		아이디: <input type="text" name="memId" value="${vo.memId}" /><br/>
		비밀번호: <input type="password" name="memPass" value="${vo.memPass}" /><br/>
		이름: <input type="text" name="memName" value="${vo.memName}" /><br/>
		이메일: <input type="text" name="memEmail" value="${vo.memEmail}" /><br/>
		연락처: <input type="text" name="memPhone" value="${vo.memPhone}" /><br/>
		생년월일: <input type="int" name="memAge" value="${vo.memAge}" /><br/>

		<input type="submit" value="등록하기"/>
	</form>
	
</body>
</html>