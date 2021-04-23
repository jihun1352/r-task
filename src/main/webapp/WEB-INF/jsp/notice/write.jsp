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
							<!-- <td class="text-left"><input multiple type="file" name="file0"/></td> -->
							<td class="text-left">
								<div class="reply_area">
								<div class="reply">
									<div class="re_left">
										<a class="btn btn-default btn-sm"
											href="javascript:fncAddFile('5');">첨부파일
											추가</a> &nbsp;&nbsp;&nbsp;<span class="info01 blue">참고&#58;
											첨부된 첫번째 이미지가 썸네일 이미지가 됩니다</span>
									</div>
								</div>
								<div id="fileUpload">
									<div class="reply" id="fileList_">
										<div class="re_left">
											<input style="display:inline;" type="file" name="file0"><a
												class="btn btn-default btn-sm"
												href="javascript:fncDeleteFile('');">파일삭제
											</a>
										</div>
									</div>
								</div>
							</div>
						</td>
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
	
	// 파일첨부 태그 추가
	function fncAddFile(num) {
		var fileIndex = $("div[id^=fileList_]").length + 1;
		var fileIndexId = new Date().getTime();
		if(num > 0 && fileIndex > num){
			alert("첨부파일은 "+num+"개까지만 가능합니다.");
			return;
		}
		$("#fileIndex").val(fileIndex);
		var str = '<div class="reply" id="fileList_'+fileIndexId+'" style="margin-top: 5px;" >';
		str += '<input style="display:inline;" type="file" name="file'+fileIndexId+'" style="margin-right: 5px;"/>';
		str += "<a href=\"javascript:fncDeleteFile('"+ fileIndexId +"');\" class='btn btn-default btn-sm'>파일삭제</a></div>";
		$("#fileUpload").append(str);
	}
	
	// 파일첨부 태그 삭제
	function fncDeleteFile(fileIndexId) {
		var cnt = $("#fileUpload div").length;
		
		var answer = confirm('삭제하시겠습니까?');
		if(answer){
			if(cnt < 1){	// 파일첨부 태그 기본 한개는 삭제하지 않고 초기화
				$("#fileList_" + fileIndexId + " input[type='file']").val('');
				return;
			}
			$("#fileList_" + fileIndexId).remove();
			$("#fileIndex").val(Number($("#fileIndex").val())-1);
		}else{
			return;
		}
	}
</script>
