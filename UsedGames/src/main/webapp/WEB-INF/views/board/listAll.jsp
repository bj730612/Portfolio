<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session ="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css">

</head>
<body>
<div class="box-body">
	<select name="searchType">
		<option value="null" <c:out value="${searchVO.searchType == null ? 'selected':''}"/>>---</option>
		<option value="b.title" <c:out value="${searchVO.searchType eq 'b.title' ? 'selected':''}"/>>제목</option>
		<option value="b.content" <c:out value="${searchVO.searchType eq 'b.content' ? 'selected':''}"/>>내용</option>
		<option value="u.name" <c:out value="${searchVO.searchType eq 'u.name' ? 'selected':''}"/>>작성자</option>
	</select>
	<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}" >
	<button type="button" class="searchBnt" onclick="searchBnt()">검색</button>
</div>




<div style="border:1px solid yellow;">
	<div style="border:1px solid blue; display:inline-block;">
		<div style="border:1px solid green;">번호</div>
		<div style="border:1px solid green;">제목</div>
		<div style="border:1px solid green;">작성자</div>
		<div style="border:1px solid green;">조회수</div>
		<div style="border:1px solid green;">날짜</div>
	</div>
	<c:forEach var="post" items="${posts}">
		<div style="border:1px solid blue; display:inline-block;">
			<div style="border:1px solid red;">${post.idx}</div>
			<a href="/board/readBoard.do${pm.makeQuery(pm.cri.page)}&boardIdx=${post.idx}"><div style="border:1px solid red;">${post.title}
<%-- 				<c:if test="${post.recnt > 0}"> --%>
					<span style="color:red;">(${post.recnt})</span>
<%-- 				</c:if> --%>
			</div></a>
			<div style="border:1px solid red;">${post.name}</div>
			<div style="border:1px solid red;">${post.viewCount}</div>
			<div style="border:1px solid red;">
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${post.writeDate}" />
			</div>
		</div>
	</c:forEach>
</div>



<ul class="pagination">
	<c:if test="${pm.prev}">
		<li class="page-item"><a class="page-link" href="/board/listAll.do${pm.makeQuery(pm.startPage - 1)}">&laquo</a></li>
	</c:if>
	
	<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="idx">
		<li class="page-item"<c:out value="${pm.cri.page == idx?'class=active':''}" />>
			<a class="page-link" href="/board/listAll.do${pm.makeQuery(idx)}">${idx}</a>
		</li>
	</c:forEach>
	
	<c:if test="${pm.next && pm.endPage > 0 }">
		<li class="page-item"><a class="page-link" href="/board/listAll.do${pm.makeQuery(pm.endPage + 1)}">&raquo</a></li>
	</c:if>
</ul>

<a href="/main.do"><button type="button">메인으로</button></a>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
	var result = '${msg}';
	if(result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	
</script>
<script type="text/javascript">

	function searchBnt() {
		self.location = "/board/listAll.do"
			+ '${pm.makeQuery(1)}'
			+ '&searchType='
			+ $("select option:selected").val()
			+ "&keyword="
			+ encodeURIComponent($('#keywordInput').val());
	}

</script>

</body>
</html>