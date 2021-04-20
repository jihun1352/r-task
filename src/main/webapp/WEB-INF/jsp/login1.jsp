<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" href="resources/css/style.css">
<div id="content_wrap">
	<div id="contents">
		<div class="inner">
			<div class="path">
				<div class="inner">
					<ul>
						<li><a href="#">내 정보</a></li>
					</ul>
				</div>
			</div>
			
			<form name="frm" id="frm">
			
			<h3>내 정보</h3>
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
							<th scope="col">성명</th>
							<td><c:out value="${result.admin_nm }"/></td>
						</tr>
						<tr>
							<th scope="col">부서명 *</th>
							<td><input type="text" id="admin_dept_nm" name="admin_dept_nm" title="부서명" value="<c:out value='${result.admin_dept_nm }' />" maxlength="50" req /></td>
						</tr>
						<tr>
							<th scope="col">연락처 *</th>
							<td>
								<input type="text" id="admin_tel" name="admin_tel" title="연락처" value="<c:out value='${result.admin_tel }' />" maxlength="50" tel req  />
								<span class="info01 grey"> ex) 02-1234-1234 </span>
							</td>
						</tr>
						<tr>
							<th scope="col">이메일 *</th>
							<td>
								<input type="text" id="admin_email" name="admin_email" title="이메일" value="<c:out value='${result.admin_email }' />" maxlength="50" email req />
								<span class="info01 grey"> ex) sample@sen.go.kr </span>
							</td>
						</tr>
						<tr>
							<th scope="col">가입일</th>
							<td><fmt:parseDate var="parseReg" value="${result.reg_dt }" pattern="yyyy-MM-dd HH:mm:ss"/>
								<fmt:formatDate var="reg_dt" value="${parseReg}" pattern="yyyy-MM-dd a KK:mm"/> 
								<c:out value="${reg_dt }"/>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div class="btn_area right">
					<a class="btn_medium bt_white f_400" href="javascript:fncUpdate();">저장</a>
				</div>
			</div>
			</form>
			
		</div>
	</div>
</div>			
<script>
//<![CDATA[
$(document).ready(function() {		

});

function fncUpdate(){	// 수정	
	if ( !doFormValidate(document.frm) ) return;
	
	if(confirm("수정하시겠습니까?")) {
		$("#frm").attr({"action": "<c:out value='${pageContext.request.contextPath}/bms/loginMng/updt0010f.do'/>", "method": "post"}).submit();
	}	
}
//]]>
</script>
