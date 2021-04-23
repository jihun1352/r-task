<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 목록 페이지 -->
	<div class="container">
		<div class="row">
			<form id="frm" name="frm">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">첨부파일</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${noticeList.totalElements > 0}">
							<c:forEach var="result" items="${noticeList.content }" varStatus="status">
								<fmt:parseDate value="${result.regDt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
								<tr>
									<td>${result.id }</td>
									<td><a href="/notice/${result.id}/${noticeList.pageable.pageNumber}"><c:out value="${result.subject}"/></a></td>
									<td><c:out value="${result.regId}"/></td>
									<td><c:out value="${result.subject}"/></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDateTime }"/></td>
								</tr>
							</c:forEach>	
						</c:when>	
						<c:otherwise>
							<tr>
								<td colspan="5">데이터가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>	
				</tbody>
			</table>
			</form>
			<!-- 페이지 넘기기 -->
			<div class="container">
			<div class="row">
				<div class="col" style="text-align:center;">
					<ul class="pagination">
						<c:choose>
							<c:when test="${noticeList.first }"></c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="/?page=${noticeList.number-1}">&lt;</a></li>
							</c:otherwise>
						</c:choose>	
						<c:forEach begin="${startPage }" end="${endPage }" var="i">
							<c:choose>
								<c:when test="${noticeList.pageable.pageNumber+1 == i }">
									<li class="page-item disabled"><a class="page-link" href="/?page=${i-1}">${i }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="/?page=${i-1}">${i }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${noticeList.last }"></c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="/?page=${noticeList.number+1}">&gt;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			</div>
			<!-- 회원만넘어가도록 -->
			
	
	
			<a href="javascript:fncWrite();" class="btn btn-primary pull-right">글쓰기</a>
		</div>	
	</div>
</body>
</html>
<script type="text/javascript">
	$(document).ready(function(){	
		if("${message}" != ''){ 	//  메세지
			alert("${message }");
		}		
	});

	function fncWrite() {
		if("${user_id}" == "") {
			alert("로그인을 해주세요.");
			$("#frm").attr({"action": "/login", "method": "get"}).submit();
		} else {
			$("#frm").attr({"action": "/notice/post", "method": "get"}).submit();
		}
	}
</script>
