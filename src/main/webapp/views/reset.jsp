<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset mật khẩu</title>
</head>
<body>
	<label>Reset mật khẩu</label>
	<form action="reset" method="post">
		<c:if test="${alert!=null}">
			<h3 class="alert alert - danger">${alert}</h3>
		</c:if>
		<section>
			<label>
				<div>
					<span> <i class="fa-solid fa-lock"></i> <input
						type="password" placeholder="mật khẩu" name="password"
						required="required"></input>
					</span>
				</div>
			</label>
		</section>
		<section>
			<label>
				<div>
					<span> <i class="fa-solid fa-lock"></i> <input
						type="password" placeholder="xác nhận mật khẩu"
						name="confirm_password" required="required"></input>
					</span>
				</div>
			</label>
		</section>
		<section>
			<button type="submit">Reset mật khẩu</button>
		</section>
	</form>
</body>
</html>