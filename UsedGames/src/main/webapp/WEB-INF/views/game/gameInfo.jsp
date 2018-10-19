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
		<div>
			<img>
			<div>
				<div>
					<p>title</p>
				</div>
				<div>
					<p>price</p>
				</div>
				<div>
					<button>장바구니</button>
					<button>구매하기</button>
				</div>
			</div>
		<p>${gameVO.title}</p>
		<p>${gameVO.price}</p>
		</div>
		<div>
			<img>
		</div>
		<div class="상품평">			
		</div>
		<div class="상품문의">
		</div>
	</div>
</body>
<c:import url="/footer.do"></c:import>
</html>