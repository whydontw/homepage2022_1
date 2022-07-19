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
<link href="/asset/style/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Yeon+Sung&display=swap" rel="stylesheet">

<!-- Slick 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">

<!-- 메인화면 포스터 넘김 효과 -->
<script>
$(function () {
    $('#slider-div').slick({
        slide: 'div',		//슬라이드 되어야 할 태그 ex) div, li 
        infinite: true, 	//무한 반복 옵션	 
        slidesToShow: 3,		// 한 화면에 보여질 컨텐츠 개수
        slidesToScroll: 1,		//스크롤 한번에 움직일 컨텐츠 개수
        speed: 100,	 // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
        arrows: true, 		// 옆으로 이동하는 화살표 표시 여부
        dots: true, 		// 스크롤바 아래 점으로 페이지네이션 여부
        autoplay: true,			// 자동 스크롤 사용 여부
        autoplaySpeed: 1500, 		// 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
        pauseOnHover: true,		// 슬라이드 이동시 마우스 호버하면 슬라이더 멈추게 설정
        vertical: false,		// 세로 방향 슬라이드 옵션
        prevArrow: "<button type='button' class='slick-prev'>Previous</button>",		// 이전 화살표 모양 설정
        nextArrow: "<button type='button' class='slick-next'>Next</button>",		// 다음 화살표 모양 설정
        dotsClass: "slick-dots", 	//아래 나오는 페이지네이션(점) css class 지정
        draggable: true, 	//드래그 가능 여부 
    });
});
</script>


<style>
	/*슬라이드 넘김 style 변경 */
	.slick-dots li button:before {
	    font-family: slick;
	    font-size: 6px;
	    line-height: 20px;
	    position: absolute;
	    top: 0;
	    left: 0;
	    width: 30px;
	    height: 30px;
	    content: '•';
	    text-align: center;
	    opacity: .25;
	    color: gold;
	    -webkit-font-smoothing: antialiased;
	}
	
	/*header img 변경*/
	#header-image-main {
	background: url('/asset/style/img/header_book.jpg');
	}
</style>

</head>


<body>

	<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>
	
	
<section>
    <div class="wrap-box">

        <div class="title-box1">
            <p>예매하기</p>
        </div>

        <div class="modify-menu">
            <p><span style="color: aquamarine; font-family: 궁서; font-size: 4em;">곧 만들 예정</span></p>
            <img src="/asset/style/img/nangman.png" alt="안 나와요">
        </div>
    </div>
</section>
	
	
	<%@ include file="/WEB-INF/jsp/main/Footer.jsp" %>


</body>

</html>