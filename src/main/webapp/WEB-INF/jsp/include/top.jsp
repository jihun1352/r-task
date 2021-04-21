<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="user_id" value="${sessionScope['user_id'] }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<!-- 애니매이션 담당 JQUERY -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 부트스트랩 JS  -->
<script src="/resources/js/bootstrap.js"></script>
<title>jsp 게시판 웹사이트</title>
</head>
<body>
	<!-- 네비게이션  -->
	<nav class="navbar navbar-default">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expaned="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">R-Support TASK.</a>
		</div>

		<div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="active"><a href="/login">로그인</a></li>
							<li><a href="/join">회원가입</a></li>
						</ul>
					</li> -->
				<c:if test="${user_id eq null }">	
					<li><a href="/login">로그인</a></li>
					<li><a href="/join">회원가입</a></li>
				</c:if>	
				<c:if test="${user_id ne null }">
					<li><strong><c:out value="${user_id }"/></strong>님</li>
					<li><a href="/logout">로그아웃</a></li>
				</c:if>
			</ul>
		</div>
	</nav>