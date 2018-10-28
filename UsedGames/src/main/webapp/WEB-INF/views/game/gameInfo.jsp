<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
.ad {
	width: 900px;
	height: 300px;
	float: left;
}
</style>
</head>
<header style="height: 160px; position: fixed; z-index: 9999;">
	<div>
		<c:import url="/header.do"></c:import>
	</div>
</header>
<body style="margin: auto; width: 900px;">
	<div style="position: relative; z-index: 1; padding-top: 160px;">
		<div class="d-flex">
			<div class="d-inline">
				<img src="/resources/uploadFile/image/${gameVO[0].image}">
			</div>
			<div>
				<div>
					<p>${gameVO[0].title}</p>
				</div>
				<div>
					<p>${gameVO[0].price}</p>
				</div>
				<div>
					<input type="hidden" name="gameIdx" value="${gameVO[0].idx}">
					<input type="hidden" name="userIdx" value="${gameVO[0].userIdx}">
					<input type="hidden" name="boardIdx" value="${gameVO[0].boardIdx}">
					<select name="quantity">
						<c:forEach begin="1" end="10" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>&nbsp;개
					<form name="form1" method="get" action="/cart/insertCart.do">
						<input type="submit" value="장바구니">
					</form>
					<form name="form2" method="get" action="/order/insertOrder.do">
						<input type="submit" value="주문하기">
					</form>					
				</div>
			</div>
		</div>
		<div>
			<p>상세 정보</p>
			<img src="/resources/uploadFile/image/${gameVO[0].subImage}">
		</div>
 		<div>
 			<%@include file="../review/review.jsp" %>
 		</div>
		<div>
			<p>상품문의</p>
<%-- 			<%@include file="../question/question.jsp" %> --%>
		</div>
	</div>
</body>
<c:import url="/footer.do"></c:import>
</html>