<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
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
				<img src="/resources/uploadFile/image/${gameVO.image}">
			</div>
			<div>
				<div>
					<p>${gameVO.title}</p>
				</div>
				<div>
					<p>${gameVO.price}</p>
				</div>
				<div>
					<form name="form1" method="get" action="/cart/insertCart.do">
						<input type="hidden" name="gameIdx" value="${gameVO.idx}">
						<select name="quantity">
							<c:forEach begin="1" end="10" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>&nbsp;개
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
			<img src="/resources/uploadFile/image/${gameVO.subImage}">
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