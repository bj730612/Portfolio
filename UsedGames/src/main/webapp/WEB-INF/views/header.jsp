<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.header {
	width: 900px;
	background-color: white;
	margin: auto;
	height: 160px;
}
#main-img {
	width: 200px;
	height: 80px;
}
#login_check {
	font-size: 12px !important;
	text-align: right;
	width: 300px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="d-flex" style="padding-top: 20px;">
			<div class="d-flex" style="width: 200px;">
				<a href="/main.do"><img id="main-img" src="../resources/uploadFile/image/ps.png"></a>
			</div>
			<div class="d-flex align-self-center" style="padding-left: 100px;">
				<input type="text" style="width: 300px; height: 2rem;">
			</div>
			<div id="login_check" class="d-flex justify-content-end">
				<c:if test="${login.email == null}">
					<a href="/user/login.do">로그인&nbsp</a>
					<a href="/user/signUp.do">회원가입&nbsp</a>
					<div class="dropdown d-inline">
						<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">고객센터</a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="#">공지사항</a>
							<a class="dropdown-item" href="#">자주 묻는 질문</a>
						    <a class="dropdown-item" href="#">마이페이지</a>
						    <a class="dropdown-item" href="#">1:1 문의</a>
						</div>
					</div>
				</c:if>
				<c:if test="${login.email != null}">
				<h6>${login.name}님 환영합니다.</h6>
					<a href="/user/logout.do">로그아웃&nbsp</a>
					<div class="dropdown d-inline">
						<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">고객센터</a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="#">공지사항</a>
							<a class="dropdown-item" href="#">자주 묻는 질문</a>
						    <a class="dropdown-item" href="#">마이페이지</a>
						    <a class="dropdown-item" href="#">1:1 문의</a>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div>
 			<c:import url="/nav.do"></c:import>
		</div>
		<c:import url="/game/gameType.do"></c:import>
		<div style="position: absolute; width: 140px; height: 600px; border: 1px solid black; margin-left: 920px;">
			<div style="text-align: center;">
			<h5>최근 본 상품</h5>
			</div>
		</div>
	</div>
</body>
</html>