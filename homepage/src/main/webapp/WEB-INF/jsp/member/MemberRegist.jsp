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
<title>Rolypoly Theater</title>

<!-- 반응형웹 설정 -->
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<!-- width=device-width: 접속한 기기의 width값을 가져옴 / initial-scale=1.0: 화면 비율 / minimum-scale=1.0: 가장 최소로 줄일수있는 비율 -->
<!-- maximum-scale=1.0: 가장 최대로 늘릴수있는(ex. 2.0이면 두배로 늘릴수있다) / user-scalable=no: 사용자가 늘릴 수 없음 -->

<!-- css 불러오기 -->
<link href="/asset/front/css/style.css" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="/asset/style/style.css" rel="stylesheet" />

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Yeon+Sung&display=swap" rel="stylesheet">

<style>
/*header img 변경*/
#header-image-main {
background: url('/asset/style/img/header_main.jpg');
}
</style>

</head>


<body>

	<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>
	
	<section>
	    <div class="wrap-box">
	        <div class="title-box1">
	            <p>회원가입</p>
	        </div>
		</div>
		
    
    <div id="sign-up-wrapbox">
		<form action="/member/add.do" method="post">
        <table class="sign-up-table">
                <!-- <tbody> -->
                    <tr>
                        <td class="sign-up-table-td1">아이디</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="text" placeholder="아이디를 입력하세요"  name="memId" value="${vo.memId}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="sign-up-table-td1">비밀번호</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="password" placeholder="비밀번호를 입력하세요" name="memPass" value="${vo.memPass}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="sign-up-table-td1">이름</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="text" placeholder="이름을 입력하세요" name="memName" value="${vo.memName}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="sign-up-table-td1">이메일</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="text" placeholder="example@example.com" name="memEmail" value="${vo.memEmail}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="sign-up-table-td1">연락처</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="text" placeholder="'-'를 제외한 숫자 11자리" name="memPhone" value="${vo.memPhone}" />
                        </td>
                    </tr>
                    <tr>
                        <td class="sign-up-table-td1">생년월일</td>
                        <td class="sign-up-table-td2">
                            <input class="input-information" type="text" placeholder="주민등록번호 앞 6자리" name="memAge" value="${vo.memAge}"/>
                        </td>
                    </tr>
                <!-- </tbody> -->
            </table>
            <div class="add-submit-btn">
                <button type="submit" class="book-submit-btn">가입하기</button>
            </div>
       </form>
    </div>
		
	</section>
	
	
	<%@ include file="/WEB-INF/jsp/main/Footer.jsp" %>


</body>

</html>