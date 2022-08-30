<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 22.06.29 login -->
	<c:choose>
		<c:when test="${empty USER_INFO.id}"> <!-- id가 비어있으면 -->
			<a href="/login/egovLoginUsr.do" class="login">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="/member/add.do">회원가입</a> <!-- 로그인 창을 띄워라 -->
		</c:when>
		<c:otherwise>
			<a href="/login/actionLogout.do"><c:out value="${USER_INFO.name}"/> 님 로그아웃</a></a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="/member/list.do">회원관리</a> <!-- 로그인 창을 띄워라 -->
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
				<div>
					<a href="/join/memberRegist.do">회원가입하기</a>
				</div>
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
	
// 	회원신청이 정상적으로 완료되었습니다. 로그인 후 이용해주세요.
	<c:if test="${not empty message}">
		alert("${message}");
	</c:if>
	</script>
	
<!-- 로그인 끝 -->