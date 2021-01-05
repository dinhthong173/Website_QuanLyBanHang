<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sản phẩm</title>
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
		</div>
		<div class="clearfix"></div>
		<div class="container_fullwidth">
			<div class="container shopping-cart">
				<div class="row">
					<div class="col-md-12">
						<h2>Chỉnh sửa thông tin sản phẩm</h2>
						<c:set value="${ttsp}" var="ttsp"></c:set>
						<c:set value="${dsdm}" var="dsdm"></c:set>
						<form
							action="QuanLySanPham_LuuSanPhamSua?masanpham=<c:out value="${ttsp.maSanPham}"/>"
							method="post" enctype="multipart/form-data"
							modelAttribute="myFile">

							<div class="form-group">
								<h4>Tên sản phẩm :</h4>
								<input type="text" class="form-control" name="tensanpham"
									value="${ttsp.tenSanPham}" required>
							</div>
							<div class="form-group">
								<h4>Giá:</h4>
								<input type="text" class="form-control" name="gia"
									value="${ttsp.gia}" required
									pattern="^([1-9][0-9]{3,10}|100000000)$">
							</div>
							<div class="form-group">
								<h4>Số lượng:</h4>
								<input type="text" class="form-control" name="soluong"
									value="${ttsp.soLuong}" required
									pattern="^([1-9][0-9]{0,10}|1000)$">
							</div>
							<div class="form-group">
								<h4>Mô tả:</h4>
								<input type="text" class="form-control" name="mota"
									value="${ttsp.moTa}" required>
							</div>
							<div class="form-group">
								<label>Hình ảnh:</label><input type="file" class="form-control"
									name="file" id="fileToUpload" accept="image/*"
									pattern=".+(jpg|jpeg|png|JPG|JPEG|PNG)$" />
							</div>
							<div class="form-group">
								<h4>Danh muc:</h4>
								<select class="form-control" name="madanhmuc">
									<c:forEach items="${dsdm}" var="dsdm">
										<option value="${dsdm.maDanhMuc}"><c:out
												value="${dsdm.maDanhMuc} | ${dsdm.tenDanhMuc}"></c:out>
										</option>
									</c:forEach>
								</select>
							</div>
							<a href="QuanLySanPham">
								<button type="button" class="btn btn-primary">Hủy</button>
							</a>
							<button type="submit" class="btn btn-primary">Lưu thay
								đổi</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js">
		
	</script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js">
		
	</script>
	<script defer src="resources/js/jquery.flexslider.js">
		
	</script>
	<script type="text/javascript"
		src="resources/js/jquery.carouFredSel-6.2.1-packed.js">
		
	</script>
	<script type="text/javascript" src="resources/js/script.min.js">
		
	</script>
</body>
</html>