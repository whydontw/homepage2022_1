<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="prefix" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>데이터 가져오기</title>
</head>
<body>
게시물 총 수 : <c:out value="${paginationInfo.totalRecordCount}"/>건 <br/>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성 시간</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}">
			<tr>
				<td><c:out value="${result.practiceId}"/></td>
				<td>
					<c:url var="viewUrl" value="/practice/select.do">
						<c:param name="practiceSb" value="${result.practiceSb}"/>
					</c:url>
					<a href="${viewUrl}"><c:out value="${result.practiceSb}"/></a>
				</td>
				<td><c:out value="${result.practiceUser}"/></td>
				<td><fmt:formatDate value="practiceTime" pattern="yyyy-MM-dd" /></td>
				<td><a href="${delUrl}" class="btn-del">삭제</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 페이징 화면 넘김 만들기 -->
	<div id="paging_div">
		<ul class="paging_align">
			<c:url var="pageUrl" value="/practice/selectList.do?"/>
			<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
			<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
		</ul>
	</div>

	<a href="/practice/practiceRegist.do">등록하기</a>
	
</body>
</html>