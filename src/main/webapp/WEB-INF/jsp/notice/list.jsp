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
						<th style="background-color: #eeeeee; text-align: center;">작성일 </th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(noticeList) > 0}">
							<c:forEach var="result" items="${noticeList }" varStatus="status">
								<fmt:parseDate value="${result.regDt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
								<tr>
									<td>${fn:length(noticeList)-status.count+1 }</td>
									<td><a href="/notice/post/${result.id}"><c:out value="${result.subject}"/></a></td>
									<td><c:out value="${result.regId}"/></td>
									<td><c:out value="${result.subject}"/></td>
									<td><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${parsedDateTime }"/></td>
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
			<div>
				<c:forEach var="pageNum" items="${pageList }" varStatus="status">
					<a href="/?page=${pageNum }">${pageNum }</a>
				</c:forEach>
			</div>
			<!-- 회원만넘어가도록 -->
			<div class="container">
			<div class="row">
				<div class="col">
					<p><strong>Pagination</strong></p>
					<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<%-- <c:forEach var="pageNum" items="${pageList }" varStatus="status">
							<li class="page-item"><a class="page-link" href="/?page=${pageNum }">${pageNum }</a></li>
						</c:forEach> --%>	
							<li class="page-item"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
	
	
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
