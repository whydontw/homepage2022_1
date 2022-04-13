<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>데이터 가져오기</title>
</head>
<body>
	<!-- 
	*method의 get, post
	1get이 post가 속도가 더 빠르다
	get이 post보다 보안이 취약함
	
	*post를 사용하는 이유
	get은 첨부파일이 안 올라가
	
	*form태그의 name tempVO가 TempVO의 경로의 변수와 이름이 일치해야해
	*label 부분은 미관상 넣지 않아도 되지만 장애인 등을 위한 편의를 위하여 >> 웹 접근성 상승
	입력창에 focus되지 않아도 라벨만 눌러도 입력창에 focus 됨
	 -->
	
	<!--  
	* 등록폼
	<form action="/temp/insert.do" method="post" name="tempVO">
	<label for="tempVal">값 정보 : </label>
	<input type="text" id="tempVal" name="tempVal" value=""/>
	<br/>
	<button type="submit">등록</button>
	</form>
	-->
	
	<c:choose>
		<c:when test="${not empty searchVO.tempId}">
			<c:set var="actionUrl" value="/temp/update.do"/>
		</c:when>
		<c:otherwise>
			<c:set var="actionUrl" value="/temp/insert.do"/>
		</c:otherwise>
	</c:choose>
	
	<form action="${actionUrl}" method="post" name="tempVO">
		<input type="hidden" name="tempId" value="${result.tempId}"/>
		<label for="tempVal">값 정보:</label>
		<input type="text" id="tempVal" name="tempVal" value="${result.tempVal}"/>
		<br/>
		<c:choose>
			<c:when test="${not empty searchVO.tempId}">
				<button type="submit">수정</button>
			</c:when>
			<c:otherwise>
				<button type="submit">등록</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>