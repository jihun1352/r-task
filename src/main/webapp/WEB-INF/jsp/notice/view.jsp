<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 상세 페이지 -->	
	<div class="container">	
		<div class="row">	
			<table class="table table-striped"	style="text-align: center; border: 1px solid #dddddd">	
				<thead>	
					<tr>	
						<th colspan="3"	style="background-color: #eeeeee; text-align: center;">글 보기</th>	
					</tr>	
				</thead>
				<tbody>	
					<tr>	
						<td style="width: 20%;">글 제목</td>	
						<td colspan="2"></td>	
					</tr>	
					<tr>	
						<td>작성자</td>	
						<td colspan="2"></td>	
					</tr>	
					<tr>	
						<td>작성일</td>	
						<td colspan="2"></td>	
					</tr>	
					<tr>	
						<td>내용</td>	
						<td colspan="2" style="min-height: 200px; text-align: left;"></td>	
					</tr>
				</tbody>	
			</table>	
			<a href="bbs.jsp" class="btn btn-primary">목록</a>
			
			<a href="update.jsp?bbsID=" class="btn btn-primary">수정</a>
	
			<a href="delete.jsp?bbsID=" class="btn btn-primary">삭제</a>
		</div>
	</div>
</body>
</html>
