<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 상세 페이지 -->	
	<div class="container">	
		<div class="row">	
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
							<c:forEach var="result" items="${fileList}" varStatus="status">
								<c:choose>
									<c:when test="${status.count > 1 }">
									<br />
									</c:when>
								</c:choose>	
								<%-- <a class="file_img" href='${pageContext.request.contextPath}/<c:out value='${authValue }' />/file/down0010f.do?attach_file_id=<c:out value="${result.attach_file_id }"/>&amp;file_seq=<c:out value="${result.file_seq }"/>&amp;alias_name=<c:out value="${result.alias_name }"/>' alt="<c:out value="${result.original_name }"/> 파일 다운로드" title="<c:out value="${result.original_name }"/> 파일 다운로드" ><img src="${pageContext.request.contextPath}/common/img/fileIcon/icon_<c:out value="${file_extsn }" />.png" alt="첨부"/>&nbsp;<c:out value="${result.original_name }"/></a> --%>
								<a href='/download/${result.id}/${result.attachFileId}'><c:out value="${result.originalName }"/></a>
							</c:forEach>
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
				<a href="update.jsp?bbsID=" class="btn btn-primary text-right">수정</a>	
				<a href="delete.jsp?bbsID=" class="btn btn-primary text-right">삭제</a>
			</c:if>
		</div>
	</div>
</body>
</html>
