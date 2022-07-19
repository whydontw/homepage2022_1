<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- 반응형웹 설정 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!-- width=device-width: 접속한 기기의 width값을 가져옴 / initial-scale=1.0: 화면 비율 / minimum-scale=1.0: 가장 최소로 줄일수있는 비율 -->
<!-- maximum-scale=1.0: 가장 최대로 늘릴수있는(ex. 2.0이면 두배로 늘릴수있다) / user-scalable=no: 사용자가 늘릴 수 없음 -->
<link rel="stylesheet " hype="style_1.css" a href="style_main.css">

<title>Rolypoly Theater</title>

<!-- css 불러오기 -->
<link href="/asset/front/css/style.css" rel="stylesheet"/>
<link href="/asset/style/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!--제이쿼리 불러오기-->
<script src="js/jquery-3.6.0.js"></script>

<!-- Slick 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">

<!-- 구글 폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Yeon+Sung&display=swap" rel="stylesheet">
<style>
#header-image-main{
    background: url('/asset/style/img/header_introduce.jpg');
}

</style>
</head>
<body>
   
   <%@ include file="/WEB-INF/jsp/main/Header.jsp" %>

    <section>

        <div class="wrap-box">

            <div class="title-box2">
                <span style="font-family: 'Yeon Sung', cursive; font-size: 1.25em;">롤리폴리 극장은?</span>
            </div>


            <div id="wrap-introduce">
                <div id="theater-picture">
                    <img src="/asset/style/img/sit_theater.png" />
                </div>
                <div id="theater-table">
                    <table>
                        <thead>
                            <tr>
                                <td class="table-title"><strong><span style="color: gold;">50년 전통</span>을 자랑하는 고딕 양식의 예술
                                        극장</strong></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="table-contents">롤리폴리 극장(Rolypoly Theater)은 1970년 캐나다의 제임스 고슬링이 대전 동구 가양동에 지은
                                    대전 최초의 고딕 양식 예술 극장입니다.<br>
                                    롤리폴리 극장은 50년 가까이 대전 공연 예술계의 문화를 주도한, 역사 깊은 문화 공간입니다. 1992년 교황 안드레아 3세가 방문하여 공연 '개발자의 인생'을 관람하고 눈물을 흘리기도 한, 아주 유서깊은 공연장입니다.</td>
                            </tr>
                            <tr>
                                <td class="table-title"><strong>예술가와 관객이 <span style="color: skyblue;">소통하는</span> 복합 문화
                                        공간</strong></td>
                            </tr>
                            <tr>
                                <td class="table-contents">롤리폴리 극장은 예술가와 관객이 공연을 매개로 자유롭게 소통하는 공간입니다.
                                공연하는 예술가와 공연을 관람하는 관객이 공연 예술을 통해서 깊은 감정적 공감을 합니다. 1996년 '자바는 사람을 자바' 작품 상연중 무대가 무너진 이후, 그것을 수리하지 않고 관객과 무대의 눈높이를 맞춤으로서 공연으로 더욱 깊은 교감이 가능하게 되었습니다.
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>


            <div class="title-box3">
                <span style="font-family: 'Yeon Sung', cursive; font-size: 1.25em;">창립자 인사말</span>
            </div>

            <div id="wrap-introduce2">
                <div id="introduce-james">
                    <img src="/asset/style/img/james_450.png" />
                </div>
                <div id="introduce-james-comment">
                    <p>어디서 오셨나요
                        자꾸 눈이 가네요 그대 눈빛이
                        나는 참 맘에 드네요
                        옆으로 가고 싶지만
                        용기가 안 나서 가슴이 떨려와
                        나는 참 망설이네요
                        몰라 어떡해 난 몰라 미치겠어
                        널 놓치기 싫어 너에게로
                        점점 다가갈래
                        점점 내 앞에서 떠날 수 없게
                        Roly poly roly roly poly
                        날 밀어내도 난 다시 네게로 다가가서
                        Roly poly roly roly poly
                        나만 보일거야
                        너에게 나를 보여 줄거야
                        Oh oh oh oh</p>
                    <br>
                    <div id="james-comment-end">2022년 전주 한옥마을에서<br>롤리폴리 극장 창립자, 제임스 고슬링 드림</div>
                </div>
            </div>

            <div id="map-box">
                <div class="title-box1">
                    <span style="font-family: 'Yeon Sung', cursive; font-size: 1.25em;">오시는 길</span>
                </div>
                <p align="middle">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d12853.514830822902!2d127.45497735!3d36.351604800000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x35654865afaae0db%3A0x3fe8bede8780ef21!2z7ZWc6rWt7Y-066as7YWN64yA7ZWZIOuMgOyghOy6oO2NvOyKpA!5e0!3m2!1sko!2skr!4v1657585267542!5m2!1sko!2skr" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </p>
            </div>

        </div> <!-- wrap-box 닫음 -->
    </section>



<%@ include file="/WEB-INF/jsp/main/Footer.jsp" %>



<script>
$(document).ready(function() {
    $(window).scroll(function(){
        $('#wrap-introduce').each( function(i){
            
            var bottom_of_element = $(this).offset().top + $(this).outerHeight();
            var bottom_of_window = $(window).scrollTop() + $(window).height();
            
            if( bottom_of_window > bottom_of_element){
                $(this).animate({'opacity':'1','margin-left':'0px'},1000);
            }
        }); 
    });
});



$(document).ready(function() {
    $(window).scroll(function(){
        $('#wrap-introduce2').each( function(i){
            
            var bottom_of_element = $(this).offset().top + $(this).outerHeight();
            var bottom_of_window = $(window).scrollTop() + $(window).height();
            
            if( bottom_of_window > bottom_of_element){
                $(this).animate({'opacity':'1','margin-left':'100px'},1000);
            }
        }); 
    });
});

</script>


</body>
</html>