<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/top.jsp" %>
	<!-- 로그인 페이지 -->
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<!-- 점보트론 -->
			<div class="jumbotron" style="padding-top: 20px;">
				<!-- 로그인 정보를 숨기면서 전송post -->
				<form id="frm">
					<h3 style="text-align: center;">로그인</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디를 입력하세요"	name="userId" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호 입력하세요"	name="userPasswd" maxlength="20">
					</div>
					<a href="javascript:fncLogin();" class="btn btn-primary form-control">로그인</a>
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

	function fncLogin() {
		$("#frm").attr({"action": "/login", "method": "post"}).submit();
	}
</script>
	
