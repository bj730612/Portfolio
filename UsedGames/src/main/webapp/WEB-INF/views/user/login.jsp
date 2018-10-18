<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
<style>
form {
	display: flex;
	flex-direction: column;
	padding-top: 200px;
}
.input-form {
	width: 350px;
	height: 2rem;
}
.pt-20 {
	padding-top: 20px;
}
</style>
</head>
<body>
<div class="d-flex" style="width: 900px; margin: auto; padding-top: 20px;">
	<a href="/main.do"><img style="width: 200px;" id="main-img" src="../resources/uploadFile/image/ps.png"></a>
</div>
<form action="/user/loginCheck.do" method="post">
	<div class="d-flex justify-content-center pt-20">
		<input  type="text" class="input-form" name="email" id="email" placeholder="USER ID" />
	</div>
	<div class="d-flex justify-content-center pt-20">
		<input type="password" class="input-form" name="password" id="password" placeholder="PASSWORD" />
	</div>
	<div class="d-flex justify-content-center pt-20">
		<label>
			<input type="checkbox" name="useCookie"> 자동로그인
		</label>
	</div>
	<div class="d-flex justify-content-center pt-20">
		<button type="submit">로그인</button>
	</div>
<div style="text-align: center; padding-top: 300px;  padding-bottom: 20px;">
	<div class="ft-copyright">Copyright ⓒ HKIT Inc. All rights	reserved.</div>
</div>
</form>
</body>
</html>