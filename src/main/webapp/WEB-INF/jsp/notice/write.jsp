<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 글작성 페이지 -->
	<div class="container">
		<div class="row">
			<form id="frm" name="frm" enctype="multipart/form-data">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">공지사항 글 등록</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2"><input type="text" class="form-control" placeholder="글 제목" name="subject" maxlength="50"/></td>
						</tr>
						<tr>
							<td colspan="2"><textarea class="form-control" placeholder="글 내용" name="content" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
						<tr>
							<th style="width: 10%;">첨부파일</th>
							<td class="text-left"><input multiple type="file" name="file0"/></td>
						</tr>
					</tbody>
				</table>	
				<a href="javascript:fncWriteIns();" class="btn btn-primary pull-right" >글쓰기</a>
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

	function fncWriteIns() {
		alert("${user_id}");
		
		if(confirm("등록하시겠습니까?")) {
			$("#frm").attr({"action":"/notice/post", "method": "post"}).submit();
		};
	}
</script>
