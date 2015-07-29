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


</head>
<body>
	<div class="panel panel-default" style="width: 70%; height:100%">
		<!-- Default panel contents -->
		<!-- Table -->
		<table class="table">
			<tr>
				<th>댓글내용</th>
				<th>작성자</th>
				<th>날짜</th>
				<th></th>
			</tr>

			<form:form action="comment_submit" method="post"
				commandName="commentForm" accept-charset="UTF-8">
				<form:input path="boardMessageSq" type="hidden" value="${board_id}" />
				<form:input path="messageStatusCd" type="hidden" value="" />
				<form:input path="Sq" type="hidden" value="" />
				<form:input path="commentSq" type="hidden" value="" />

				<c:forEach var="commment" items="${listComment}">
					<tr>
						<td>${commment.messageText}</td>
						<td>${commment.userSq}</td>
						<td>${commment.insertTime}</td>
						<td><a class="btn btn-default" role="button"
							onclick="showReplyInputText(${commment.sq})"> 대댓글</a></td>
						<td><a class="btn btn-default"
							onClick="checkDataBeforeSubmit('2', ${commment.sq}, '${commment.messageText}')"
							role="button"> 삭제</a></td>
					</tr>
					<tr id="reply_${commment.sq}" style="display: none;">
						<td></td>
						<td colspan="3"><textarea class="form-control" rows="10"
								placeholder="대댓글을 입력해주세요" id="reReplyText_${commment.sq}"></textarea></td>
						<td><a class="btn btn-default"
							onClick="insertReReply('1', ${commment.sq})"
							role="button"> 등록</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5">댓글 쓰기 <br> <form:textarea
							path="messageText" class="form-control" rows="10"
							placeholder="댓글을 입력해주세요" value="${commentForm.messageText}"></form:textarea>
					</td>
				</tr>
				<tr>
					<td colspan="5"><input class="btn btn-default" type="submit"
						value="submit" /></td>
				</tr>
			</form:form>

		</table>
	</div>

	<script>
		//대댓글 show /hidden
		function showReplyInputText(sq)
		{
			if (document.getElementById("reply_"+sq).style.display !="")				
				document.getElementById("reply_"+sq).style.display = "";
			else 
				document.getElementById("reply_"+sq).style.display = "none";
		}
		
		//대댓글 입력 -> submit
		function insertReReply(messageStatusCd, commentSq) {
			document.getElementById("Sq").value = 0;
			
			var messageText = document.getElementById("reReplyText_"+commentSq).value;
			checkDataBeforeSubmit(messageStatusCd, 0, messageText, commentSq)
		}
		
		//submit 전 데이터 채움
		function checkDataBeforeSubmit(messageStatusCd, Sq, messageText, commentSq) {
			//if (typeof(commentSq)==='undefined') document.getElementById("Sq").value = "";
			
			//이미 있는 댓글 update 
			if (Sq == "")
				document.getElementById("Sq").value = 0;
			else
				document.getElementById("Sq").value = Sq;
			
			//유저에 의해 삭제  : 유저 확인 후 -> 메시지 상태 삭제 상태(2)로 변경; 상태 코드 관리 어떻게하지 매번 DB에서 읽을 수는 없는데..
			document.getElementById("commentSq").value = commentSq;
			document.getElementById("messageStatusCd").value = messageStatusCd;
			document.getElementById("messageText").value = messageText;
			
			document.getElementById("commentForm").submit();
		}
	</script>

</body>
</html>