<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
<style>
.input{margin-right:5px}
.reply{display:inline-block;width:100%; border-bottom: 1px dotted #d2d2d2; padding:10px 0}
.reply .re_left{float: left; width:80%;}
.reply .re_left span{font-size: 13px;/* color:#3e3e3e */}
.reply .re_left span b{font-weight: 700;margin-right:10px;color: #000}
.reply .re_right{float: right; text-align: right;margin-top: 10px}
</style>
	<!-- 공지사항 수정 페이지 -->
	<div class="container">
		<div class="row">
			<form id="frm" name="frm" enctype="multipart/form-data">
			<input type="hidden" name="_method" value="put">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">공지사항 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2"><input type="text" class="form-control" name="subject" value="${result.subject }" maxlength="50"/></td>
						</tr>
						<tr>
							<td colspan="2"><textarea class="form-control" name="content" maxlength="2048" style="height: 350px;"><c:out value="${result.content }"></c:out></textarea></td>
						</tr>
						<tr>
							<th style="width: 10%;">첨부파일</th>
							<td class="text-left">
								<div class="reply_area">
								<div class="reply">
									<div class="re_left">
										<a class="btn btn-default btn-sm"
											href="javascript:fncAddFile('5');">첨부파일
											추가</a>
									</div>
								</div>
								<c:if test="${fn:length(fileList) > 0 }">
									<input type="hidden" name="attachFileId" value="${fileList.get(0).attachFileId }"/>
				                        <c:forEach var="file" items="${fileList }" varStatus="status">
				                        <div class="reply" id="fileList_<c:out value="${status.index}"/>">
											<div class="re_left">
												<a href='/download/${file.id}/${file.attachFileId}'><c:out value="${file.originalName }"/></a>
												<a class="btn btn-default btn-sm" href="javascript:fncDeleteFileProc('${file.attachFileId }','${file.id}','${file.aliasName }','${status.index }','${file.filePath }');">파일삭제</a>
											</div>
										</div>
				                        </c:forEach>
				                        </c:if>
								<div id="fileUpload">
								<c:if test="${fn:length(fileList) < 5 }">
									<div class="reply" id="fileList_<c:out value="${fn:length(fileList) }" />">
										<div class="re_left">
											<input style="display:inline;" type="file" name="file0"><a
												class="btn btn-default btn-sm"
												href="javascript:fncDeleteFile('');">파일삭제
											</a>
										</div>
									</div>
								</c:if>	
								</div>
							</div>
						</td>
						</tr>
					</tbody>
				</table>	
				<!-- <input type="hidden" name="_method" value="put"> -->
				<a href="javascript:fncModify();" class="btn btn-primary pull-right">수정</a>
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

	function fncModify() {
		id = "${result.id}";
		if(confirm("수정 하시겠습니까?")) {
			$("#frm").attr({"action": "/notice/post/"+id+"?page=${pageNum}", "method": "post"}).submit();
		}
	}
	
	// 등록되어 있는 첨부 삭제
	function fncDeleteFileProc(attachFileId, fileId, aliasName, fileIndex, filePath) {	// 파일 삭제
		if(fileId == null || fileId == '') {
			if(confirm("삭제하시겠습니까?")) {
				$("#fileList_" + fileIndex).remove();
				$("#fileIndex").val(Number($("#fileIndex").val())-1);
			}else{
				return;
			}
		} else {
			if(confirm("선택한 파일을 삭제하시겠습니까?")) {
				$.ajax({
					url: '/notice/file/'+fileId,
					dataType: 'json',
					type: 'post',
					data: {
						attachFileId: attachFileId,
						fileId: fileId,
						aliasName: aliasName,
						filePath: filePath
					},
					success: function(e) {
						if(e.deleteResult){
							$("#fileList_" + fileIndex).remove();
							$("#fileIndex").val(Number($("#fileIndex").val())-1);
							alert('선택한 파일이 삭제되었습니다.');
						}else{
							alert(e.message);
						}
					},
					error: function(e) {
						alert("파일삭제 실패");
					}
				});
			}
		}
	}
</script>
