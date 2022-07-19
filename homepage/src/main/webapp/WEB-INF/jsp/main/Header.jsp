<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<header>
    <div id="header-image-main">
        <div id="rolypoly-log-in">

	<%@ include file="/WEB-INF/jsp/main/LogIn.jsp" %>
	
		</div>
	        <a href='<c:url value="/mainpage.do"/>'><img src="/asset/style/img/logo/logo_small.png"/></a>
	    </div>
	    <nav class="menu-wrap">
	        <ul>
	            <li><a href='<c:url value="/mainpage.do"/>'><h3>메인화면</h3></a></li>
	            <li><a href='<c:url value="/introduce.do"/>'><h3>소개하기</h3></a></li>
	            <li><a href='<c:url value="/book.do"/>'><h3>예매하기</h3></a></li>
	            <li><a href='<c:url value="/apply.do"/>'><h3>대관신청</h3></a></li>
	            <li><a href='<c:url value="/board/selectList.do"/>'><h3>공연후기</h3></a></li>
	        </ul>
	    </nav>
</header>