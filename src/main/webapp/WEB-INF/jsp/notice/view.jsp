<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 상세 페이지 -->	
	<div class="container">	
		<div class="row">	
			<form id="frm" name="frm">
			<table class="table table-striped"	style="text-align: center; border: 1px solid #dddddd">	
				<thead>	
					<tr>	
						<th colspan="4"	style="background-color: #eeeeee; text-align: center;">공지사항 상세 조회</th>	
					</tr>	
				</thead>
				<tbody>	
					<tr>	
						<th class="text-center" style="width: 20%;">글 제목</th>	
						<td class="text-left" colspan="3"><c:out value="${result.subject }"/></td>	
					</tr>	
					<tr>	
						<th class="text-center">작성자</th>	
						<td class="text-left" colspan="3"><c:out value="${result.regId }"/></td>	
					</tr>	
					<tr>	
						<th class="text-center">작성일</th>	
						<fmt:parseDate value="${result.regDt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedRegDt" type="both" />
						<td class="text-left"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedRegDt }"/></td>	
						<th class="text-center">수정일</th>	
						<fmt:parseDate value="${result.uptDt}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedUptDt" type="both" />
						<td class="text-left"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedUptDt }"/></td>
					</tr>	
					<tr>
						<th class="text-center">첨부파일</th>
						<td class="text-left" colspan="3">
							<c:if test="${fn:length(fileList) > 0 }">
								<c:forEach var="result" items="${fileList}" varStatus="status">
									<c:choose>
										<c:when test="${status.count > 1 }">
										<br />
										</c:when>
									</c:choose>	
									<a href='/download/${result.id}/${result.attachFileId}'><c:out value="${result.originalName }"/></a>
								</c:forEach>
							</c:if>
						</td>
					</tr>
					<tr>	
						<td class="text-center" colspan="4" style="min-height: 200px;">
							<textarea class="col-xs-12" rows="9" disabled ><c:out value="${result.content }"/></textarea>
						</td>
					</tr>
				</tbody>	
			</table>	
			<a href="/?page=${pageNum}" class="btn btn-primary text-right">목록</a>
			<c:if test="${user_id eq result.regId }">
				<a href="/notice/post/${id}?page=${pageNum}" class="btn btn-primary text-right">수정</a>
				<input type="hidden" name="_method" value="delete">
				<a href="javascript:fncDelete();" class="btn btn-primary text-right">삭제</a>
			</c:if>
			</form>
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

function fncDelete() {
	id = "${result.id}";
	if(confirm("삭제 하시겠습니까?")) {
		$("#frm").attr({"action": "/notice/post/"+id, "method": "post"}).submit();
	};
}

</script>
