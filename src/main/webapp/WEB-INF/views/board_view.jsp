<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<script type="text/javascript">
// iframe resize
function autoResize(i)
{
    var iframeHeight=
    (i).contentWindow.document.body.scrollHeight;
    (i).height=iframeHeight+20;
}
</script>

</head>
<body>
	<%@include file="board_navibar.jsp"%>
	<form:form id="boardMessageForm" action="board_submit" method="post"
		commandName="boardMessageForm">
		
			<form:input path="insertTime" type="hidden" value="${boardMessageForm.insertTime}" />
			<form:input path="messageTitle" type="hidden" value="${boardMessageForm.messageTitle}" />
			<form:input path="messageSq" type="hidden" value="${boardMessageForm.messageSq}" />
			<form:input path="userSq" type="hidden" value="${boardMessageForm.userSq}" />
			<form:input path="messageText" type="hidden" value="${boardMessageForm.messageText}" />
			<form:input path="messageStatusCd" type="hidden" value="${boardMessageForm.messageStatusCd}" />

		<div class="panel panel-default" style="width: 70%">
			<!-- Default panel contents -->

			<div class="panel-heading">${boardMessageForm.messageTitle}</div>
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
					<td>본문</td>
				</tr>
				<tr>
					<td>${boardMessageForm.messageText}</td>
				</tr>
			</table>
			<div>
				<a class="btn btn-default"
					href="board_edit?id=${boardMessageForm.messageSq}" role="button">글수정</a>
				<a class="btn btn-default" onClick="deleteBoardByUser()"
					role="button">글삭제</a>
			</div>
		</div>
	</form:form>
	<iframe src="comment_list?board_id=<%=request.getParameter("id")%>" style="border:none;overflow:hidden;" width="100%" onload="autoResize(this)" scrolling="no">
	
	</iframe>
	<script>
		function deleteBoardByUser() {
			//유저에 의해 삭제  : 유저 확인 후 -> 메시지 상태 삭제 상태(2)로 변경; 상태 코드 관리 어떻게하지 매번 DB에서 읽을 수는 없는데..
			document.getElementById("messageStatusCd").value = 2;
			
			document.getElementById("boardMessageForm").submit();
		}
	</script>
	
</body>
</html>