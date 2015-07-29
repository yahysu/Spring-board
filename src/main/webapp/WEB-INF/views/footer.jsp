<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!-- footer -->

<div>
	<nav>

		<ul class="pagination">
			<c:if test="${pageNum <= 0}">
				<c:set value="disabled" var="prevActiveType"></c:set>
			</c:if>

			<li class="${prevActiveType}"><a onClick="goPrev(${pageNum})"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			
			<c:forEach begin="0" end="${pageSize}" step="1" var="i">
				<c:if test="${pageNum==i}">
					<c:set value="active" var="activeType"></c:set>
				</c:if>
				<c:if test="${pageNum!=i}">
					<c:set value="" var="activeType"></c:set>
				</c:if>
				<li class="${activeType}"><a
					href="/board/board_list?pageNum=${i}">${i+1}</a></li>
			</c:forEach>

			<c:if test="${pageNum >= pageSize}">
				<c:set value="disabled" var="nextActiveType"></c:set>
			</c:if>
			<li class="${nextActiveType}"><a
				onClick="goNext(${pageNum}, ${pageSize})" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</div>
<script>
	function goPrev(pageNum) {
		if(pageNum > 0) pageNum = pageNum-1;
		location.href = "/board/board_list?pageNum="+pageNum;
	}
	function goNext(pageNum, pageSize) {
		if(pageNum < pageSize) pageNum = pageNum+1;
		location.href = "/board/board_list?pageNum="+pageNum;
	}
	</script>