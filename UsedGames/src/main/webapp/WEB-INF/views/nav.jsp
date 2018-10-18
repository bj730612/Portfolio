<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap/css/bootstrap.css">
</head>
<body>
	<div class="row" style="text-align: left;">
		<div class="col">
			<div class="dropdown">
				<a class="dropdown-toggle" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">전체 카테고리</a>

				<div class="dropdown-menu dropright" aria-labelledby="dropdownMenuButton">
					<c:forEach var="gameCategory2" items="${gameCategory2s}">
						<a class="dropdown-toggle dropdown-item" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="/game/gameList.do?category2=${gameCategory2.idx}">${gameCategory2.name}</a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
							<c:forEach var="gameCategory3" items="${gameCategory3s}">
								<a class="dropdown-item" href="/game/gameList.do?category2=${gameCategory2.idx}&category3=${gameCategory3.idx}">${gameCategory3.name}"${gameCategory2.idx}</a>
							</c:forEach>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col">
			<a href="#">맞춤추천</a>
		</div>
		<div class="col">
			<a href="#">추가할인</a>
		</div>
		<div class="col">
			<a href="#">신규등록</a>
		</div>
		<div class="col">
			<a href="#">판매예정</a>
		</div>
		<div style="padding-left: 10px; text-align: right;">
			<a href="/board/insertBoard.do">판매하기</a>
		</div>
		<div style="padding-left: 10px; text-align: right;">
			<a href="/board/listAll.do">커뮤니티</a>
		</div>

	</div>