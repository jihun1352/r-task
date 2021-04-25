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