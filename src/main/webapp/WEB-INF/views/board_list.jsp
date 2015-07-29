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
<%@include file="board_navibar.jsp"%>
	<div class="panel panel-default" style="width:70%">
		<!-- Default panel contents -->
		<div class="panel-heading">게시판 입니다.</div>
		<div class="panel-body">
			<p>으허허헣허허허허헣 게시판 입니다.</p>
		</div>

		<!-- Table -->
		<table class="table">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>날짜</th>
			</tr>
			<c:forEach var="boardMessage" items="${listBoardMessage}">
                <tr>
                    <td>${boardMessage.messageSq}</td>
                    <td><a href="/board/board_view?id=${boardMessage.messageSq}">${boardMessage.messageTitle}</a></td>
                    <td>${boardMessage.insertTime}</td>
                             
                </tr>
                </c:forEach>             
		</table>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>