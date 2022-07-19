<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	호옹이
	
	<div class="box-btn">
		<c:url var="uptUrl" value="/practice/practiceRegist.do">
			<c:param name="practiceId" value="${result.practiceId}"/>
		</c:url>
		<a href="${uptUrl}">수정</a>
		
		<c:url var="delUrl" value="/practice/delete.do">
			<c:param name="practiceId" value="${result.practiceId}"/>
		</c:url>
		<a href="${delUrl}" class="btn-del">삭제</a>
		<a href="/practice/selectList.do">목록</a>		
	</div>
	<script>
	$(document).ready(function(){
		$(".btn-del").click(function() {
			if(!confirm("삭제하시겠습니까?")){
				return false;
			}
		});
	});
	</script>
</body>
</html>