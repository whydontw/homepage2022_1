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
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<title>예약을해봅쉬다</title>
<!-- BBS Style -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet"/>
<link href="/asset/front/css/style.css" rel="stylesheet"/>

<!-- 공통 Style -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<style type="text/css">

body{
background: black;
}
</style>



</head>


<body>

<c:url var="_BASE_PARAM" value="">
	<c:param name="resveId" value="${searchVO.resveId }"/>
	<c:param name="pageIndex" value="${searchVO.pageIndex }"/>
	<c:if test="${not empty searchVO.searchCondition }">
		<c:param name="searchCondition" value="${searchVO.searchCondition }"/>
	</c:if>
	<c:if test="${not empty searchVO.searchKeyword }">
		<c:param name="searchKeyword" value="${searchVO.searchKeyword }"></c:param>
	</c:if>
</c:url>

<!-- content 시작 -->
<div id="content">
	<div class="container">
		<div id="contents">
			<div id="bbs_wrap">
				<div class="board_view">
					<dl class="tit_view">
						<dt>프로그램명</dt>
						<dd>
							<c:out value="${result.resveSj }"/>
						</dd>
					</dl>
					<dl class="tit_view">
						<dt>신청유형</dt>
						<dd>
							<c:choose>
								<c:when test="${result.resveSeCode eq 'TYPE01' }">선착순</c:when>
								<c:when test="${result.resveSeCode eq 'TYPE02' }">승인관리</c:when>
							</c:choose>
						</dd>
					</dl>
					<dl class="tit_view">
						<dt>강사명</dt>
						<dd>
							<c:out value="${result.recNm }"/>
						</dd>
					</dl>
					<dl class="info_view">
						<dt>운영일자</dt>
						<dd>
							<c:out value="${result.useBeginDt }"/> ~ <c:out value="${result.useEndDt }"/>
						</dd>
						<dt>운영시간</dt>
						<dd>
							<c:out value="${result.useBeginTime }"/> ~ <c:out value="${result.useEndTime }"/>
						</dd>
						<dt>신청기간</dt>
						<dd>
							<c:out value="${result.reqstBgnde }"/> ~ <c:out value="${result.reqstEndde }"/>
						</dd>
						<dt>신청가능한 인원</dt>
						<dd>
							<c:out value="${result.maxAplyCnt }"/>
						</dd>
					</dl>
					<dl class="info_view2">
						<dt>작성자 ID</dt>
						<dd>
							<c:out value="${result.frstRegisterId }"/>
						</dd>
						<dt>작성일</dt>
						<dd>
							<fmt:formatDate value="${result.frstRegistPnttm }" pattern="yyyy-MM-dd"/>
						</dd>
					</dl>
					<div class="view_cont">
						<c:out value="${result.resveCn }" escapeXml="false" />
					</div>
				</div>
				
				<div class="btn-cont ar">
					<c:choose>
						<c:when test="${result.applyStatus eq '1' }">
							<a href="#" class="btn btn-status" data-status="${result.applyStatus }">접수대기중</a>
						</c:when>
						<c:when test="${result.applyStatus eq '2' }">
							<a href="/rsv/rsvApplyRegist.do${_BASE_PARAM }" id="btn-apply" class="btn spot">신청</a>
						</c:when>
						<c:when test="${result.applyStatus eq '3' }">
							<a href="#" class="btn btn-status" data-status="${result.applyStatus }">접수마감</a>
						</c:when>
						<c:when test="${result.applyStatus eq '4' }">
							<a href="#" class="btn btn-status" data-status="${result.applyStatus }">운영중</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-status" data-status="${result.applyStatus }">종료</a>
						</c:otherwise>
					</c:choose>
					<c:url var="listUrl" value="/rsv/selectList.do${_BASE_PARAM }" />
					<a href="${listUrl }" class="btn">목록</a>
				</div>
			</div>
		</div>
	</div>
</div>
	<!-- contents 끝 -->
	
<script>

//자바스크립트는 소문자로 바꿔서 / 대문자로 표현하고 싶으면 하이픈을 사용해서 표현 (예: data-valB ~~> data-valb)
 
 $(document).ready(function(){
	 //예약상태메시지
	 $(".btn-status").click(function(){
		 var status = $(this).data("status"); //status라는 값을 변수값으로 위의 data-status
		 
		 if(status == "1"){
			 alert("현재 접수 대기중 상태입니다.");
		 }else if(status == "3"){
			 alert("현재 접수 마감 상태입니다.");
		 }else if(status == "4"){
			 alert("현재 운영중 상태입니다.");
		 }else if(status == "5"){
			 alert("현재 종료 상태입니다.");
		 }
	 });
	 
	 //신청
	 $("#btn-reg").click(function(){
		 if(!confirm("신청하시겠습니까?")){
			 return false;
		 }
	 });
	 
	 //신청가능여부 체크 후 진행
	 $("#btn-apply").click(function(){
		 var href = $(this).attr("href");
		 
		 $.ajax({
			 type: "POST",
			 url : "/rsv/rsvCheck.json",
			 data : {"resveId" : "${searchVO.resveId}"},
			 dataType : "json",
			 success : function(result){
				 if(result.successYn == "Y"){
					 location.href = href;
// 					 alert("접수 가능!");
				 }else{
					 alert(result.message);
				 }
			 },error : function(result){
				 alert("error");
			 }
		 });
		 
		 return false;
	 });
 });
</script>

</body>
</html>