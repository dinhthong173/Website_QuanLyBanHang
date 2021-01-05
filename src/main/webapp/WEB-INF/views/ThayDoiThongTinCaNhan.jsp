<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thay đổi thông tin cá nhân</title>
<link rel="shortcut icon" href="resources/images/HinhWebsite/logo.png">
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/flexslider.css"
	type="text/css" media="screen" />
<link href="resources/css/styleQuanLy.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<%@ include file="header.jsp"%>
			<div class="clearfix"></div>
			<div class="page-index">
				<div class="container">
					<p>Cập nhật thông tin cá nhân</p>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="container_fullwidth">
			<div class="container shopping-cart">
				<div class="row">
					<h5 class="text-danger">
						<c:out value="${thongbao}"></c:out>
					</h5>
					<br />
				</div>
				<div class="row">
					<div class="col-md-12">
						<h4>
							Chỉnh sửa thông tin tài khoản cá nhân:
							<c:out value="${thongtin.username}"></c:out>
						</h4>
						<br />
						<form:form ModelAttribute="nguoidung" method="POST"
							action="ThayDoiThongTin">
							<div class="form-group">
								<h4>Họ tên</h4>
								<input type="text" class="form-control" name="tenNguoiDung"
									value="${thongtin.tenNguoiDung}" required>
							</div>
							<div class="form-group">
								<h4>Địa chỉ</h4>
								<input type="text" class="form-control" name="diaChi"
									value="${thongtin.diaChi}" required>
							</div>
							<div class="form-group">
								<h4>Email</h4>
								<input type="text" class="form-control" name="email"
									value="${thongtin.email}" required>
							</div>
							<div class="form-group">
								<h4>Số điện thoại</h4>
								<input type="text" class="form-control" name="soDienThoai"
									value="${thongtin.soDienThoai}" required>
							</div>
							<p style="color: blue;">Nếu muốn thay đổi mật khẩu thì vui
								lòng điền lại thông tin phía dưới.</p>
							<div class="form-group">
								<h4>Mật khẩu củ</h4>
								<input type="password" class="form-control" name="oldPassword"
									value="${thongtin.pass}">
							</div>
							<div class="form-group">
								<h4>Mật khẩu mới</h4>
								<input type="password" class="form-control" name="pass"
									value="${thongtin.pass}">
							</div>
							<div class="form-group">
								<h4>Gõ lại mật khẩu</h4>
								<input type="password" class="form-control"
									name="passwordconfirm" value="${thongtin.pass}">
							</div>
							<a href="ThongTinCaNhan">
								<button type="button" class="btn btn-primary">Hủy</button>
							</a>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script defer src="resources/js/jquery.flexslider.js"></script>
	<script type="text/javascript"
		src="resources/js/jquery.carouFredSel-6.2.1-packed.js"></script>
	<script type="text/javascript" src="resources/js/script.min.js"></script>
</body>
</html>