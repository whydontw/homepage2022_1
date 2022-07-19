<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<!-- 반응형웹 설정 -->
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<!-- width=device-width: 접속한 기기의 width값을 가져옴 / initial-scale=1.0: 화면 비율 / minimum-scale=1.0: 가장 최소로 줄일수있는 비율 -->
<!-- maximum-scale=1.0: 가장 최대로 늘릴수있는(ex. 2.0이면 두배로 늘릴수있다) / user-scalable=no: 사용자가 늘릴 수 없음 -->
<title>로그인을해보자</title>
<!-- css 불러오기 -->
<link href="/asset/front/css/style.css" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<!-- 22.06.29 login -->
	<c:choose>
		<c:when test="${empty USER_INFO.id}"> <!-- id가 비어있으면 -->
			<a href="/login/egovLoginUsr.do" class="login">로그인</a> <!-- 로그인 창을 띄워라 -->
		</c:when>
		<c:otherwise>
			<a href="/login/actionLogout.do"><c:out value="${USER_INFO.name}"/>님 로그아웃</a>
		</c:otherwise>
	</c:choose>
	
<!-- 로그인 레이어 + html 작업 -->
	<div class="dim"></div>
	
<!-- 로그인 -->
	<div class="layer-popup layer-login" style="display: none;">
		<header class="layer-header">
			<span class="logo">
				<span class="img-logo">한국폴리텍대학 대전캠퍼스 스마트소프트웨어학과</span>
			</span>
			<button type="button" class="layer-close"><span>팝업닫기</span></button>
		</header>
		<div class="layer-body">
			<form action="/login/actionLogin.do" id="frmLogin" name="frmLogin" method="post" onsubmit="return vali()">
				<input type="hidden" name="userSe" value="USR"/>
				<fieldset>
					<legend>로그인을 위한 아이디 / 비밀번호 입력</legend>
					<div class="ipt-row">
						<input type="text" id="loginId" name="id" placeholder="아이디" required="required">
					</div>
					<div class="ipt-row">
						<input type="password" id="loginPw" name="password" placeholder="비밀번호" required="required">
					</div>
					<button type="submit" class="btn-login"><span>로그인</span></button>
				</fieldset>
			</form>
		</div>
	</div>
	
	<script>
	$(document).ready(function() {
		//로그인
		$(".login").click(function(){
			$(".dim, .layer-login").fadeIn();
			return false;
		});
		
		//레이어 닫기
		$(".layer-close").click(function(){
			$(".dim, .layer-login").fadeOut();
			return false;
		});
	});
	
	
	
	//input required 태그를 쓰지않으면 나오는 function	
	function vali(){
		if(!$("#loginId").val()){
			alert("아이디를 입력해주세요.");
			$("#loginId").focus();
			return false;
		}
		if(!$("#loginPw").val()){
			alert("아이디를 입력해주세요.");
			$("#loginPw").focus();
			return false;
		}
	}
	
	<c:if test="${not empty loginMessage}">
		alert("${loginMessage}");
	</c:if>
	</script>
</body>
</html>