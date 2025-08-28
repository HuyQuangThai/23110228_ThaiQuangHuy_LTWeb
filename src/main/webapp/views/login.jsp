<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập tài khoản</title>
<script src="https://kit.fontawesome.com/915c2c9532.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="login" method="post">
		<h2>Đăng nhập tài khooản</h2>
		<c:if test="${alert!=null}">
			<h3 class="alert alert - danger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa-solid fa-lock"></i></span>
					<input type="text" placeholder="mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<button type="submit" class="btn btn-login">
				<i class="fa fa-sign-in"></i> Đăng nhập
			</button>
		</section>
	</form>
</body>
</html>