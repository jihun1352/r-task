<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 로그인 페이지 -->
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;">
				<!-- 로그인 정보를 숨기면서 전송post -->
				<form id="frm" class="form-horizontal">
					<h3 style="text-align: center;">회원가입</h3>
					<div class="form-group">
					    <label for="userId" class="col-sm-2 control-label">ID</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="userPasswd" class="col-sm-2 control-label">PW</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="userPasswd" name="userPasswd" placeholder="비밀번호">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <a href="javascript:fncJoin();" class="btn btn-primary form-control">가입</a>
					    </div>
					  </div>
				</form>

			</div>

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
	
	function fncJoin() {
		if(confirm("가입 하시겠습니까?")) {
			$("#frm").attr({"action": "/join", "method": "post"}).submit();
		}	
	}
</script>
