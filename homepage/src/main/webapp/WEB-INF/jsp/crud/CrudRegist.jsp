<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>데이터 가져오기</title>
<style>

</style>
</head>
<body>
	<c:choose>
		<c:when test="${not empty searchVO.crudId}">
			<c:set var="actionUrl" value="/crud/update.do"/>
		</c:when>
		<c:otherwise>
			<c:set var="actionUrl" value="/crud/insert.do"/>
		</c:otherwise>
	</c:choose>
	
	<form action="${actionUrl}" method="post" name="crudVO">
	
		<input type="hidden" name="crudId" value="${result.crudId}"/>
		
		<label for="crudSj">제목:</label>
		<input type="text" id="crudSj" name="crudSj" value="${result.crudSj}"/><br/>
		
		<label for="userNm">작성자:</label>
		<input type="text" id="userNm" name="userNm" value="${result.userNm}"/><br/>

		<label for="crudCn">내용:</label>
		<textarea rows="20" cols="50" name="crudCn"><c:out value="${result.crudCn}"></c:out></textarea><br/>
		<!-- input type의 text는 한 줄 작성할 크기로만 나온다 / 따라서 textarea 태그를 사용해야 한다 -->
		<!-- <textarea rows="가로크기" cols="세로크기"></textarea> -->
		<!-- textarea 태그는 여는 태그와 닫는 태그 사이에 해야 값이 나온다 -->
		
		<c:choose>
			<c:when test="${not empty searchVO.crudId}">
				<button type="submit">수정</button>
			</c:when>
			<c:otherwise>
				<button type="submit">등록</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>