<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<script src="https://kit.fontawesome.com/915c2c9532.js" crossorigin="anonymous"></script>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.account == null}">
		<div class="col-sm-6">
			<ul class="list-inline right-topbar pull-right">
				<li> <a href="${pageContext.request.contextPath }/login"> Đăng nhập</a> </li>
				<li> <a href="${pageContext.request.contextPath }/register">Đăng ký</a></li>
				<li><i class="search fa fa-search search-button"></i></li>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
		<div class="col-sm-6">
			<ul class="list-inline right-topbar pull-right">
				<li><a
					href="${pageContext.request.contextPath
}/member/myaccount">${sessionScope.account.fullName}</a>
					| <a href="${pageContext.request.contextPath }/logout">Đăng
						Xuất</a></li>
				<li><i class="search fa fa-search search-button"></i></li>
			</ul>
		</div>
	</c:otherwise>
</c:choose>
</body>
</html>