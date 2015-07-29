<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% request.setCharacterEncoding("UTF-8"); %>

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
	<form:form action="board_submit" method="post"
		commandName="boardMessageForm" accept-charset="UTF-8">
		<c:if test="${boardMessageForm.insertTime!=null}">
			<form:input path="insertTime" type="hidden"
				value="${boardMessageForm.insertTime}" />
		</c:if>


		<form:input path="messageSq" type="hidden"
			value="${boardMessageForm.messageSq}" />
		<form:input path="userSq" type="hidden"
			value="${boardMessageForm.userSq}" />
		<form:input path="messageStatusCd" type="hidden"
			value="${boardMessageForm.messageStatusCd}" />


		<div class="panel panel-default" style="width: 70%">
			<!-- Default panel contents -->
			<div class="panel-heading">

				<form:input path="messageTitle" type="text" class="form-control"
					placeholder="글제목을 입력해주세요" value="${boardMessage.messageTitle}"></form:input>

			</div>
			<!-- Table -->
			<table class="table">
				<tr>
					<td>글번호 : ${boardMessageForm.messageSq}</td>
				</tr>
				<tr>
					<td>작성자 : ${boardMessageForm.userSq}</td>
				</tr>
				<tr>
					<td>글쓴시간 : ${boardMessageForm.insertTime}</td>
				</tr>
				<tr>
					<td>수정시간 : ${boardMessageForm.modifyTime}</td>
				</tr>
				<tr>
					<td>본문 <br> <form:textarea path="messageText"
							class="form-control" rows="10" placeholder="글본문을 입력해주세요"
							value="${boardMessage.messageText}"></form:textarea>
					</td>
				</tr>
			</table>
		</div>

		<div>
			<input class="btn btn-default" type="submit" value="submit" /> <a
				class="btn btn-default" onClick="goBack()" role="button">취소</a>
		</div>
	</form:form>




	<script>
		function goBack() {
			window.history.back();
		}
	</script>

</body>
</html>