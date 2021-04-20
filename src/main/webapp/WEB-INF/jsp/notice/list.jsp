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
					<tr>
						<td>작성일</td>
						<td><a href="view.jsp?bbsID=aa>">작성일</a></td>
						<td>작성일</td>
						<td>작성일</td>
						<td>작성일</td>
					</tr>
				</tbody>
			</table>
			</form>
			<!-- 페이지 넘기기 -->
			
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
			$("#frm").attr({"action": "/write", "method": "get"}).submit();
		}
	}
</script>
