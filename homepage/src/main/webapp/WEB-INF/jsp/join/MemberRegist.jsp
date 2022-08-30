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
<!-- BBS Style -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet" />
<!-- <link href="/asset/style/style.css" rel="stylesheet"/> -->
<!-- 공통 Style -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<%-- <%@ include file="/WEB-INF/jsp/main/Header.jsp" %> --%>

<div class="wrap">

<form id="frm" name="frm" method="post" action="/join/insertMember.do" onsubmit="return regist();">
<!-- 비밀번호 직접 입력하는 form method는 무조건 post로 -->
<!-- SNS 로그인 = SNS명 + "-" + SNS아이디 값  ex. kakao-123, naver-123 -->
	<input type="hidden" name="loginType" value="${searchVO.loginType}"/>
	<input type="hidden" id="idCheckAt" value="N"/>
	
	
	<!-- name ~~> 서버에 값을 보내는 명, vo와 변수명을 같게함 -->
	<table class="mT50 mB50">
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="emplyrId" name="emplyrId"/>
					<button type="button" id="btn-id-check" class="btn">아이디 중복 검사</button>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="userNm" name="userNm"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th> <!-- 비교만 하면 되지 java에서는 굳이 필요없는 정보 -->
				<td><input type="password" id="password2" /></td>
			</tr>
			<tr>
				<th>비밀번호 힌트</th>
				<td><input type="text" id="passwordHint" name="passwordHint" /></td>
			</tr>
			<tr>
				<th>비밀번호 정답</th>
				<td><input type="text" id="passwordCnsr" name="passwordCnsr" /></td>
			</tr>
		</tbody>
	</table>
	
	<div class="btn-cont ac">
		<button type="submit" class="btn spot">가입</button>
	</div>
</form>

</div>

<%-- <%@ include file="/WEB-INF/jsp/main/Footer.jsp" %> --%>


<script>
	$(document).ready(function(){
		//아이디 중복 검사
		$("#btn-id-check").click(function(){
			var emplyrId = $("#emplyrId").val();
			
			if(emplyrId){
// 				ajax
				$.ajax({
					url : "/join/duplicateCheck.do", //이 url을 통해 값을 보내
					type : "post",	// get/post 여부 정하기
					data : {"emplyrId" : emplyrId}, // {내가 파라미터로 받을 명칭 : 사용자가 입력한 값 , :, : ...}
					dataType : "json",
					success : function(data){
						if(data.successYn == "Y"){
							alert("사용 가능한 ID입니다.");
							$("#idCheckAt").val("Y");
						}else{
							alert(data.message);
							$("#idCheckAt").val("N");
						}
					}, error : function(){
						alert("error");
					}
				});
// 				ajax 끝
			}else{
				alert("ID를 입력해주세요.");
			}
		});
	});
	
	//validateion 체크
	function regist(){
		//아이디 중복 검사 체크
		if($("#idCheckAt").val() != "Y"){
			alert("아이디 중복 검사를 해주세요.");
			return false;
		}else if(!$("#emplyrId").val()){
			alert("아이디를 입력해 해주세요.");
			return false;
		}else if(!$("#userNm").val()){
			alert("이름을 입력해 해주세요.");
			return false;
		}else if(!$("#password").val()){
			alert("비밀번호를 입력해 해주세요.");
			return false;
		}else if(!$("#password2").val()){
			alert("비밀번호 확인을 입력해 해주세요.");
			return false;
		}else if(!$("#passwordHint").val()){
			alert("비밀번호 힌트를 입력해 해주세요.");
			return false;
		}else if(!$("#passwordCnsr").val()){
			alert("비밀번호 정답을 입력해 해주세요.");
			return false;
		}else if($("#password").val() != $("#password2").val()){
			alert("비밀번호와 비밀번호 확인 정보가 다릅니다.");
			return false;
		}
	}
</script>

</body>
</html>