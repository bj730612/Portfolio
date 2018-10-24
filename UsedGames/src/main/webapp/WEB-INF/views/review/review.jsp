<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
</head>
<body>
<script>
function add_review(boardIdx) {
	var userVO = "<%=session.getAttribute("login")%>"
	
	if(userVO == "null") {
		alert("로그인이 필요합니다.");
		self.location("/user/login.do");
	} else{
		$.ajax({
			type : "POST",
			url : "/review/insertReview.do",
			dataType : "JSON",
			data : $("#reviewForm").serialize(),
			complete : function(data) {
				if(data == "success") {
					alert("댓글이 등록 되었습니다.1");
					alert(userVO);
					getReviewList();
				}
			},
			error : function() {
				alert("댓글이 등록 되었습니다.2");
				getreviewList();
				$("#review").val("");
			}
		});	
	}
}

$(function() {
	getReviewList();
});

function getReviewList() {
	$.ajax({
		type : "GET",
		url : "/review/selectReview.do",
		dataType : "json",
		data : $("#reviewForm").serialize(),
		success : function(data) {
			var html = "";
			var cCnt = data.length;
			if (data.length > 0) {
				for (i = 0; i < data.length; i++) {
					html += "<div>";
					html += "<div><table class='table'><h6><strong>"+ data[i].name + "</strong></h6>";
					html += data[i].comment+ "<tr><td></td></tr>";
					html += "</table></div>";
					html += "</div>";
				}
			} else {
				html += "<div>";
				html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
				html += "</table></div>";
				html += "</div>";
			}
			$("#cCnt").html(cCnt);
			$("#reviwList").html(html);
		},
		error : function(request, status, error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
						
	});
}
</script>
<div>
	<form id="reviewForm" name="reviewForm" method="post">
		<div>
			<span><strong>상품평</strong></span> <span id="cCnt"></span>
		</div>
		<div>
			<input type="text" id="review" name="review" placeholder="상품평을 입력 해 주세요."> <br>
			<div>
				<a href='#' onClick="add_review('${gameVO[0].boardIdx}')" class="btn pull-right btn-success">평가 등록</a>
            </div>
		</div>
		<input type="hidden" id="boardIdx" name="boardIdx" value="${gameVO[0].boardIdx}" />
	</form>
</div>

<div>
	<form id="reviewListForm" name="reviewListForm" method="post">
		<div id="reviewList"></div>
	</form>
</div>

</body>
</html>