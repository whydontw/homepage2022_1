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
	background: url('/asset/style/img/header_apply.jpg');
	}
</style>

</head>


<body>

	<%@ include file="/WEB-INF/jsp/main/Header.jsp" %>
	
	
	<section>
    
  <div class="wrap-box">
        <div class="title-box1">
            <p>대관신청</p>
        </div>

        <div class="theater-rental-alert">
            <h1>※ 대관시 주의사항</h1>
            <p>1. 본 극장에서는 공연, 시사회, 각종 행사 등의 이유로 대관이 가능하오니 희망 시간에 따라 대관 신청을 하시기 바랍니다.</p>
            <p>2. 공연장은 <span style="color: red;">최소 10일 전에</span> 예약하여야 사용 가능합니다.</p>
            <p>3. 대관 가능 시간은 AM 08:00 ~ PM 20:00이며, 하절기에는 심야 대관 신청이 가능합니다. (AM 01:00시까지 운영)</p>
            <p>4. 행사를 위한 장비 문의는 신청서 하단의 '사용용도'란에 추가 작성 바랍니다.</p>
        </div>

        </div>

		<div id="theater-rental-gwan">
			<img src="/asset/style/img/javagwan.png" />
			<img src="/asset/style/img/pythongwan.png" />
			<img src="/asset/style/img/clanguagegwan.png" />
		</div>

		<div id="theater-rental-table">
            <table>
                <tbody>
                    <tr>
                        <td class="table-column1">신청관</td>
                        <td class="table-column2">
                            <select>
                                <option>자바관</option>
                                <option>파이썬관</option>
                                <option>C언어관</option>
                            </select>
                        </td>
                    </tr>
                
                    <tr>
                        <td class="table-column1">희망일시</td>
                        <td class="table-column2" colspan="3">
                            <select>
                                <option>2022</option>
                                <option>2023</option>
                                <option>2024</option>
                            </select>년&nbsp;
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                            </select>월&nbsp;
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                                <option>13</option>
                                <option>14</option>
                                <option>15</option>
                                <option>16</option>
                                <option>17</option>
                                <option>18</option>
                                <option>19</option>
                                <option>20</option>
                                <option>21</option>
                                <option>22</option>
                                <option>23</option>
                                <option>24</option>
                                <option>25</option>
                                <option>26</option>
                                <option>27</option>
                                <option>28</option>
                                <option>29</option>
                                <option>30</option>
                                <option>31</option>
                            </select>일&nbsp;
                            <select>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                                <option>13</option>
                                <option>14</option>
                                <option>15</option>
                                <option>16</option>
                                <option>17</option>
                                <option>18</option>
                                <option>19</option>
                                <option>20</option>
                                <option>21</option>
                                <option>22</option>
                                <option>23</option>
                                <option>24</option>
                            </select>시&nbsp;
                            <select>
                                <option>00</option>
                                <option>30</option>
                            </select>분&nbsp;<br>
                            이용희망시간:&nbsp;
                            <select>
                                <option>2</option>
                                <option>4</option>
                                <option>6</option>
                            </select>시간
                        </td>
                    </tr>
                    <tr>
                        <td class="table-column1">예약자명</td>
                        <td class="table-column2" colspan="3" style="padding: -50px 0 -50px 0;">
                            <input class="input-information" type="text" placeholder="이름을 입력하세요"><br>
                            <input class="input-information" type="text" placeholder="이메일을 입력하세요"><br>
                            <input class="input-information" type="text" placeholder="연락처를 입력하세요">
                        </td>
                    </tr>
                    <tr id="table-row">
                        <td class="table-column1">사용용도</td>
                        <td class="table-column2" colspan="3"><textarea placeholder="내용을 입력하세요"></textarea></td>
                    </tr>
                </tbody>
            </table>

            <button type="submit" class="book-submit-btn" onclick="location.href='#'">신청</button>
        </div>

    </div> <!-- wrap-box 닫음 -->     

	</section>
	
	<%@ include file="/WEB-INF/jsp/main/Footer.jsp" %>

</body>

</html>