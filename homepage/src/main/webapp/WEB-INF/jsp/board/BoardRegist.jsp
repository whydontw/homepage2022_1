<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 에디터가 들어가야하는 등록 페이지 -->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>수업용 게시판</title>
<!-- BBS Style -->
<link href="/asset/BBSTMP_0000000000001/style.css" rel="stylesheet" />
<!-- 공통 Style -->
<link href="/asset/LYTTMP_0000000000000/style.css" rel="stylesheet" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdn.tiny.cloud/1/9ru8dstfx7mlw5wlx81k96tvbyp43qh0bdiwha9p5yaqal2o/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
<!-- ※ tiny 툴바가 제공하는 사이트 수정 가이드에 맞추어 사용하기 -->
<!-- 글 저장: 에디터 → textarea(by ) -->
<script>
$(function(){
    var plugins = [
//     	내가 쓰고싶은 기능을 여기에 추가
        "advlist", "autolink", "lists", "link", "image", "charmap", "print", "preview", "anchor",
        "searchreplace", "visualblocks", "code", "fullscreen", "insertdatetime", "media", "table",
        "paste", "code", "help", "wordcount", "save"
    ];
    var edit_toolbar = 'formatselect fontselect fontsizeselect |'	//| 기능: 기능들 끼리 띄어있는 공백(editor 모양 참고)
               + ' forecolor backcolor |'
               + ' bold italic underline strikethrough |'
               + ' alignjustify alignleft aligncenter alignright |'
               + ' bullist numlist |'
               + ' table tabledelete |'
               + ' link image';

    tinymce.init({
    	language: "ko_KR", //한글판으로 변경
        selector: '#boardCn',	//==id가 boardCn인것을 찾아가라는 뜻, ** 에디터와의 연결 고리 **
        height: 500,
        menubar: false,
        plugins: plugins,
        toolbar: edit_toolbar,
        
        /*** image upload ***/
        image_title: true,
        /* enable automatic uploads of images represented by blob or data URIs*/
        automatic_uploads: true,
        /*
            URL of our upload handler (for more details check: https://www.tiny.cloud/docs/configure/file-image-upload/#images_upload_url)
            images_upload_url: 'postAcceptor.php',
            here we add custom filepicker only to Image dialog
        */
        file_picker_types: 'image',
        /* and here's our custom image picker*/
        file_picker_callback: function (cb, value, meta) {
            var input = document.createElement('input');
            input.setAttribute('type', 'file');
            input.setAttribute('accept', 'image/*');

            /*
            Note: In modern browsers input[type="file"] is functional without
            even adding it to the DOM, but that might not be the case in some older
            or quirky browsers like IE, so you might want to add it to the DOM
            just in case, and visually hide it. And do not forget do remove it
            once you do not need it anymore.
            */
            input.onchange = function () {
                var file = this.files[0];

                var reader = new FileReader();
                reader.onload = function () {
                    /*
                    Note: Now we need to register the blob in TinyMCEs image blob
                    registry. In the next release this part hopefully won't be
                    necessary, as we are looking to handle it internally.
                    */
                    var id = 'blobid' + (new Date()).getTime();
                    var blobCache =  tinymce.activeEditor.editorUpload.blobCache;
                    var base64 = reader.result.split(',')[1];
                    var blobInfo = blobCache.create(id, file, base64);
                    blobCache.add(blobInfo);

                    /* call the callback and populate the Title field with the file name */
                    cb(blobInfo.blobUri(), { title: file.name });
                };
                reader.readAsDataURL(file);
            };
            input.click();
        },
        /*** image upload ***/
        
        content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px }'
    });
});
</script>
</head>
<body>

<c:choose>
	<c:when test="${not empty searchVO.boardId}">
		<c:set var="actionUrl" value="/board/update.do"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="/board/insert.do"/>
	</c:otherwise>
</c:choose>

<div class="container">
<div id="contents">
	<form action="${actionUrl}" method="post" id="frm" name="frm" onsubmit="return regist()" enctype="multipart/form-data">
<!-- onsubmit: form table의 유효성을 검사하는 데에 사용함, 예를 들면 제목이 필수값일 때 비었는지 안 비었는지 확인해 준다거나 -->
<!-- 정상이면 regist() 실행(*맨 하단 참고) -->
<!-- onsubmit의 return 뒤에 true가 생략되어 있는 상태 -->
		<input type="hidden" name="boardId" value="${result.boardId}"/>
		<!-- 첨부파일 삭제시 등록 페이지에 그대로 돌아오게 하는 -->
		<input type="hidden" name="returnUrl" value="/board/boardRegist.do"/>
		
		<table class="chart2" >
			<caption>게시글 작성</caption>
			<!-- caption: 표의 제목  / 이 표는 제목과 어쩌구저쩌구로 이루어져 있습니다 하고 설명을 달아놓으면 장애인들이 잘 알 수 있다 -->
			<colgroup>		<!-- colgroup: 열 너비 조정 -->
				<col style="width:120px"/>
				<col/>	<!-- device 크기에 따라서 전체 크기에서 -width:120한 나머지값을 가져간다 -->
			</colgroup>
		<tbody>	<!-- thead없이 tbody 쓴 이유: 제목-게시판-글이 세로로 되어 있어서 하나로 묶기 힘들다 -->
			<tr>
				<th scope="row">제목</th> <!-- 제목이 열(세로)로 되어있다 -->
				<td>
					<input type="text" id="boardSj" name="boardSj" title="제목 입력" class="q3" value="<c:out value="${result.boardSj}"/>"/>
				</td>
			</tr>
			<tr>
				<th scope="row">공지 여부</th>
				<td>
					<label for="noticeAtY">예: </label>
					<input type="radio" id="noticeAtY" value="Y" name="noticeAt" <c:if test="${result.noticeAt eq 'Y'}">checked="checked"</c:if> />
						<!-- checkbox: 여러개를 선택할 수 있으므로 VO에서 array로 받아야, 복수선택 가능  -->
						<!-- radio는 택 1 무조건해야함: 공지여부가 예 혹은 아니오 둘 중 하나를 선택해야 하기 때문에 이 경우에는 radio를 사용함 -->
						<!-- checked 옵션: 접속 default -->
					&nbsp;&nbsp;&nbsp;
					<label for="noticeAtN" >아니오: </label>
					<input type="radio" id="noticeAtN" value="N" name="noticeAt" <c:if test="${result.noticeAt ne 'Y'}">checked="checked"</c:if> />
			<%--	처음 사이트를 들어왔을 때는 null값임 / 근데 예/아니오 둘 중 하나를 무조건 선택해야 하는 구조, radio라서 / 사람들이 다 선택하고 넘어가는 경우는 아니니까
 					그래서 default 값으로 아니오를 해야 한다 그래서 "${result.noticeAt ne 'Y'}"를 넣어줘야 --%>
				</td>
			</tr>
			<tr>
				<th scope="row">비공개 여부</th>
				<td>
					<label for="noticeAtY">예: </label>
					<input type="radio" id="othbcAtY" value="Y" name="othbcAt" <c:if test="${result.othbcAt eq 'Y'}">checked="checked"</c:if> />
					&nbsp;&nbsp;&nbsp;
					<label for="noticeAtN" >아니오: </label>
					<input type="radio" id="othbcAtN" value="N" name="othbcAt" <c:if test="${result.othbcAt ne 'Y'}">checked="checked"</c:if> />
				<%-- 여기 또한 '아니오'가 default 값 --%>
				</td>
			</tr>
			<tr>
				<th scope="row">작성자 ID</th>
				<td>
					<c:out value="${USER_INFO.id}"/>
				</td>
			</tr>
			<tr>
				<th scope="row">내용</th>
				<td>
					<textarea id="boardCn" name="boardCn" rows="15" title="내용입력"><c:out value="${result.boardCn}"/></textarea>
				<%-- textarea와 c:out을 한 줄로 써야 하는 이유: enter 치면 한 줄 떨어져서 출력됨, 세번 enter치면 세줄 떨어져서 출력되고...	 !!!!! textarea 쓸 때 꼭 주의합시다!!!!!!! --%>
				<%-- tiny가 찾아가는 selector: '#boardCn' --%>
				</td>
			</tr>
			
			<c:if test="${not empty result.atchFileId}">
				<tr>
					<th scope="row">기존<br>첨부파일목록</th>
					<td>
						<c:import url="/cmm/fms/selectFileInfsForUpdate.do" charEncoding="utf-8">
							<c:param name="param_atchFileId" value="${result.atchFileId}"/>
						</c:import>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<th scope="row">파일첨부</th>
				<td>
					<input type="file" name="file_1"/><br>
					<input type="file" name="file_2"/><br>
					<input type="file" name="file_3"/><br>
					<input type="file" name="file_4"/><br>
					<input type="file" name="file_5"/><br>
					<input type="file" name="file_6"/><br>
					<input type="file" name="file_7"/><br>
					<input type="file" name="file_8"/><br>
					<input type="file" name="file_9"/><br>
					<input type="file" name="file_10"/><br>
					<input type="file" name="file_11"/><br>
					<input type="file" name="file_12"/><br>
					<input type="file" name="file_13"/><br>
					<input type="file" name="file_14"/><br>
					<input type="file" name="file_15"/><br>
					<input type="file" name="file_16"/><br>
				</td>
			</tr>
		</tbody>
		</table>
		<div class="btn-cont ar">
		<!-- cont와 ar 사이의 띄어쓰기는 class가 두개라는 뜻 -->
			<c:choose>
				<c:when test="${not empty searchVO.boardId}">
					<c:url var="uptUrl" value="/board/update.do">
						<c:param name="boardId" value="${result.boardId}"/>
					</c:url>
					<a href="${uptUrl}" id="btn-reg" class="btn">수정</a>

					<c:url var="delUrl" value="/board/delete.do">
						<c:param name="boardId" value="${result.boardId}"/>
					</c:url>
					<a href="${delUrl}" id="btn-del" class="btn">
						<i class="ico-del"></i>삭제</a>					
				</c:when>
				<c:otherwise>
					<a href="#none" id="btn-reg" class="btn spot">등록</a>
				</c:otherwise>
			</c:choose>
			<c:url var="listUrl" value="/board/selectList.do"/>
			<a href="${listUrl}" class="btn">취소</a>
		</div>
	</form>
</div>
</div>
<script>
$(document).ready(function(){	//click: 소스 다 렌더링 후에 적용하라는 것 
	//게시글 등록
	$("#btn-reg").click(function(){
		$("#frm").submit();
		return false;	//클릭 이벤트에 대한 비활성
	});
	
	//게시글 삭제
	$("#btn-del").click(function(){
		if(!confirm("삭제하시겠습니까?")){
		return false;
		}
	});
});

function regist() {
	if(!$("#boardSj").val()){	//val: value값 가지고 오기
		alert("제목을 입력해주세요.");
		return false;	//true로 가지 않고 종료
	}
	
	//에디터 내용 저장
	//내가 editor에서 작성한 것을 저장하여 db에다가 저장하는 거
	$("#boardCn").val(tinymce.activeEditor.getContent());
}
</script>
</body>
</html>