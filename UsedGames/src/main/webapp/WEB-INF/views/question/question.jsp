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
function add_question(boardIdx) {
	var memberVO = "<%=session.getAttribute("login")%>"
	
	if(memberVO == "null") {
		alert("로그인이 필요합니다.");
		self.location("/member/login.do");
	} else{
		$.ajax({
			type : "POST",
			url : "/question/insertQuestion.do",
			dataType : "JSON",
			data : $("#questionForm").serialize(),
			complete : function(data) {
				if(data == "success") {
					alert("상품평이 등록 되었습니다.1");
					alert(memberVO);
					getQuestionList();
				}
			}
		});	
	}
}

$(function() {
	getQuestionList();
});

function getQuestionList() {
	$.ajax({
		type : "GET",
		url : "/question/selectQuestion.do",
		dataType : "json",
		data : $("#questionForm").serialize(),
		success : function(data) {
			var html = "";
			var cCnt = data.length;
			if (data.length > 0) {
				for (i = 0; i < data.length; i++) {
					html += "<div>";
					html += "<div><table class='table'><h6><strong>"+ data[i].name + "</strong></h6>";
					html += data[i].content+ "<tr><td></td></tr>";
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
			$("#questionList").html(html);
		},
		error : function(request, status, error) {
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
						
	});
}
</script>
<div>
	<form id="questionForm" name="questionForm" method="post">
		<div>
			<span><strong>상품문의</strong></span> <span id="cCnt"></span>
		</div>
		<div>
			<input type="text" id="content" name="content" placeholder="상품문의를 입력 해 주세요."> <br>
			<div>
				<a href='#' onClick="add_question('${gameVO[0].boardIdx}')" class="btn pull-right btn-success">문의 등록</a>
            </div>
		</div>
		<input type="hidden" id="boardIdx" name="boardIdx" value="${gameVO[0].boardIdx}" />
	</form>
</div>

<div>
	<form id="questionListForm" name="questionListForm" method="post">
		<div id="questionList"></div>
	</form>
</div>

</body>
</html>