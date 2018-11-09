<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
<script type="text/javascript" src="https://unpkg.com/jquery@3.3.1/dist/jquery.js"></script>
</head>
<body>
	<script>
		$.ajax({
			url : "/game/categoryList.do",
			type : "GET",
			data : null,
			async : false,
			dataType : "JSON",
			success : function(data) {
				alert(data);
			},
			error : function() {
				alert("error");
			}
		});
	</script>
	<h4>test</h4>
	<hr>
	<hr>
	<hr>
	<c:forEach var="gameCategories" items="${gameCategories}">
		<div>${gameCategories.name}</div>
	</c:forEach>
	<c:forEach var="gameCategory2s" items="${gameCategory2s}">
		<div>${gameCategory2s.name}</div>
	</c:forEach>
	<hr>
	<hr>
	<hr>
</body>
</html>