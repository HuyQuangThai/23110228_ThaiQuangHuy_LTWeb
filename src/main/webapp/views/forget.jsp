<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
	<form action="forget" method="post">
		<c:if test="${alert!=null}">
			<h3 class="alert alert - danger">${alert}</h3>
		</c:if>
		<section>
			<label>Email hoặc số điện thoại</label>
		</section>
		<section>
			<input type="text" name="email_or_phone" required>
		</section>
		<section>
			<button type="submit">Gửi yêu cầu</button>
		</section>
	</form>
	<p>
		<a href="${pageContext.request.contextPath}/login">Quay lại trang
			đăng nhập</a>
	</p>
</body>
</html>