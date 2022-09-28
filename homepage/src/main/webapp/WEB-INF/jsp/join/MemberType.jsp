<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<%-- <%@ include file="/WEB-INF/jsp/main/Header.jsp" %> --%>

<div class="wrap">
	<nav>
		<a href="/join/memberRegist.do?loginType=normal" class="member-type">일반회원가입</a>
		<a class="btn-kakao" href="#" data-type="join">
			<img src="http://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="150" alt="카카오 로그인 버튼"/>
		</a>
		
	<!-- 22.09.07 Naver login -->
		<a class="btn-naver" href="${naverAuthUrl}" data-type="join">
			<img src = "/asset/front/images/common/btn-naver.png" width="150" alt="네이버 로그인 버튼"/>
		</a>
	</nav>
</div>


<form id="joinFrm" name="joinFrm" method="post" action="/join/insertMember.do">
	<input type="hidden" name="loginType" value=""/>
	<input type="hidden" name="emplyrId"/>
	<input type="hidden" name="userNm"/>
</form>


<!-- js 이용한 카카오 로그인 -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	$(document).ready(function(){
		//카카오 로그인 버튼
		$(".btn-kakao").click(function(){
			const type = $(this).data("type");
			kakaoLogin(type);
			return false;
		});
	});
	
	//카카오 키 정보 입력
	Kakao.init('3577cb0289acf4135a8ea62296c16476');
	
	//카카오 SDK 초기화
	Kakao.isInitialized();
	
	//카카오 로그인
	function kakaoLogin(type){
		Kakao.Auth.login({
			success: function (response){
				Kakao.API.request({
					url: '/v2/user/me', //api 버전, 지속적 업데이트 필요
					success: function (response){
						console.log(response)
						/*$("input[name=loginType]").val("KAKAO"); // "KAKAO" ~~> 로그인타입
						if(type == "join"){ //회원가입으로~
							$("input[name=emplyrId]").val(response.id);
							$("input[name=userNm]").val(response.properties.nickname);
							
							$("#joinFrm").submit();
						}else{
							$("input[name=id]").val(reponse.id);
							$("#frmLogin").submit();
						}*/
					},
					fail: function (error){
						console.log(error)
					},
				})
			}, fail: function (error){
				console.log(error)
			},
		})
	}
</script>



<%-- <%@ include file="/WEB-INF/jsp/main/Footer.jsp" %> --%>

</body>
</html>