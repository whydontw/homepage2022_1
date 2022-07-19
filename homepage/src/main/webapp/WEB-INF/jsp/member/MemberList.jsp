<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>데이터 가져오기</title>

<style>
body{
/* background: black; */
}
section {
	margin: 0 auto;
	width: 1200px;
}

table {
	border: 3px solid black;
	width: 1000px;
	height: auto;
	text-align: center;
/* 	color: white; */
margin: 50px auto;
}

table caption{
font-size: 80px;
font-family: 궁서;
padding: 50px 0 50px 0;
}

table th{
 border-bottom: 2px solid black;
 border-right: 2px solid black;
 height:50px;
 background: pink;
}

table tr, td{

	border-right: 2px solid black; 
	width: 100px;
	height: 50px;

}

.memberlist-add{
	margin: 0 auto;
	font-size: 30px;
	float: right;
}
.memberlist-add a{
	text-decoration: none;
	color: red;
}


</style>

</head>
<body>
	<section>
	<table>
	<caption>롤리폴리 극장 고객리스트</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>Email</th>
				<th>연락처</th>
				<th>생년월일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="memVo" items="${memList}">
				<tr>
					<td><c:out value="${memVo.memId}" /></td>
					<td><c:out value="${memVo.memPass}" /></td>
					<td><c:out value="${memVo.memName}" /></td>
					<td><c:out value="${memVo.memEmail}" /></td>
					<td><c:out value="${memVo.memPhone}" /></td>
 					<td><c:out value="${memVo.memAge}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="memberlist-add">
		<a href="/mainpage.do">메인화면</a> | 
		<a href="/member/add.do">회원등록하기</a>
	</div>
	
	</section>
	
</body>
</html>