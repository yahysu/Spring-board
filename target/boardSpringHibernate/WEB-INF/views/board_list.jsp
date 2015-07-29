<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 상단 네비게이션 바 -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<!-- 브라우저가 좁아졋을때 나오는 버튼(클릭시 메뉴출력) -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse"></button>
				<a class="navbar-brand" href="#">게시글 리스트</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">글쓰기</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="panel panel-default" style="width:70%">
		<!-- Default panel contents -->
		<div class="panel-heading">게시판 입니다.</div>
		<div class="panel-body">
			<p>게시판 입니다.</p>
		</div>

		<!-- Table -->
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="boardMessage" items="${listBoardMessage}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${boardMessage.messageTitle}</td>
                    <td>${boardMessage.insertTime}</td>
                             
                </tr>
                </c:forEach>             
		</table>
	</div>
	<div>
		<nav>
			<ul class="pagination">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>