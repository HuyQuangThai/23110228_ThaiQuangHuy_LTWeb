<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Xin chào user ${sessionScope.username}</h2>
	<p>Chúc mừng bạn đã đăng nhập thành công</p>

	<form action="logout" method="get">
		<button type="submit">
			<i class="fa-solid fa-right-from-bracket"></i> Đăng xuất
		</button>
	</form>
</body>
</html>