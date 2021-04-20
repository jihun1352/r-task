<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <jsp:directive.include file="include/top.jsp" /> --%>		
<%@ include file="../include/top.jsp" %>
		<div id="contentArea">
			<div id="content_wrap">
				<div id="contents">
					<div class="inner">
						<div class="path">
							<div class="inner">
								<ul>
									<li><a href="#"><img src="${pageContext.request.contextPath }/common/img/ico_home.png" alt="" /></a></li>
									<li><a href="#">로그인</a></li>
								</ul>
							</div>
						</div>
						
						<form name="frm" id="frm">
						
						<h3>로그인</h3>
						<!-- saerchbox  -->
						<div class="board_list">
							<table class="table table_view">
								<caption class="hide">내 정보 수정</caption>
								<colgroup>
									<col style="width:15%" />
									<col style="width:75%" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="col">아이디</th>
										<td><input type="text" id="userId" name="userId" title="아이디" value="" maxlength="50" req /></td>
									</tr>
									<tr>
										<th scope="col">비밀번호</th>
										<td><input type="text" id="userPasswd" name="userPasswd" title="비밀번호" value="" maxlength="50" req /></td>
									</tr>
								</tbody>
							</table>
							
							<div class="btn_area right">
								<a class="btn_medium bt_white f_400" href="javascript:fncLogin();">로그인</a>
							</div>
						</div>
						</form>
						
					</div>
				</div>

		</div>
	</div>
	<div id="footer">
		<p>Copyright (C) 2019 	MCST. All rights reserved.</p>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		
		if("${message }" != ''){ 	//  메세지
			alert("${message }");
		}
		
	});

	function fncLogin() {
		$("#frm").attr({"action": "/login", "method": "post"}).submit();
	}
</script>
</body>
</html>		