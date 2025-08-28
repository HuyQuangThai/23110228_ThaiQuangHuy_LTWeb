<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<script src="https://kit.fontawesome.com/915c2c9532.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input type="text" placeholder="Tài khoản" name="username"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa fa-user"></i>
					</span> <input type="text" placeholder="Họ tên" name="fullname"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="fa-solid fa-envelope"></i>
					</span> <input type="text" placeholder="Nhập email" name="email"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="fa-solid fa-phone"></i>
					</span> <input type="text" placeholder="Nhập số điện thoại" name="phone"
						class="form-control">

				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"> <i class="fa-solid fa-lock"></i>
					</span> <input type="password" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<label class="input login-input">
				<div class="input-group">
					<span clas="input-group-addon"> <i class="fa-solid fa-lock"></i>
					</span> <input type="password" placeholder="Mật khẩu" name="password"
						class="form-control">
				</div>
			</label>
		</section>
		<section>
			<button type="submit" class="btn btn-register">Tạo tài khoản
			</button>
		</section>
	</form>

</body>
</html>