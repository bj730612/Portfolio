<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap/css/bootstrap.css">
</head>
<header style="height: 160px; z-index: 9999;">
	<div>
		<c:import url="/header.do"></c:import>
	</div>
</header>
<body style="margin: auto; width: 900px;">
	<div>
		<p>장바구니</p>
		<table class="table">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" aria-label="Checkbox for following text input"></th>
					<th scope="col">상품정보</th>
					<th scope="col">가격</th>
					<th scope="col">수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cartVO" items="${cartVOs}">
					<tr>
						<td><input type="checkbox" aria-label="Checkbox for following text input"></td>
						<td>${cartVO.title}</td>
						<td>${cartVO.price}</td>
						<td>${cartVO.quantity}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<ul class="pagination">
		<c:if test="${pm.prev}">
			<li class="page-item"><a class="page-link"
				href="/user/cartList.do${pm.makeQuery(pm.startPage - 1)}">&laquo</a></li>
		</c:if>

		<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="idx">
			<li class="page-item"
				<c:out value="${pm.cri.page == idx?'class=active':''}" />><a
				class="page-link" href="/user/cartList.do${pm.makeQuery(idx)}">${idx}</a>
			</li>
		</c:forEach>

		<c:if test="${pm.next && pm.endPage > 0 }">
			<li class="page-item"><a class="page-link"
				href="/user/cartList.do${pm.makeQuery(pm.endPage + 1)}">&raquo</a></li>
		</c:if>
	</ul>

	<a href="/main.do"><button type="button">메인으로</button></a>
</body>
</html>