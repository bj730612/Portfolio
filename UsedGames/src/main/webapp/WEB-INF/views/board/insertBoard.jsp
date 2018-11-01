<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">
<script>
</script>
</head>
<body>
<form role="form" method="POST" enctype="multipart/form-data">
	<div>
		게시글 선택 <select name="idx">
			<c:forEach var="post" items="${posts}">
				<option value="${post.idx}">${post.name}</option>
			</c:forEach>
		</select>
	</div>
	제목 <input type="text" name="title">
	<br><br>
	내용 <textarea name="content"></textarea>
	<br><br>
	이미지 <input type="file" name="image_file">
	<br><br><br><br>
	<input type="submit" value="작성완료">
</form>
<a href="/main.do">메인으로</a>
</body>
</html>
