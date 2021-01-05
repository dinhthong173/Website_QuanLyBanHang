<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="resources/images/HinhWebsite/logo.png">
<title>Chi tiết sản phẩm</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/flexslider.css"
	type="text/css" media="screen" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<%@ include file="header.jsp"%>
			<div class="clearfix"></div>
			<div class="page-index">
				<div class="container">
					<p>Thông tin món ăn</p>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="container_fullwidth">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<c:set value="${ttsp}" var="ttsp"></c:set>
						<div class="products-details">
							<div class="preview_image">
								<div class="preview-small">
									<img id="zoom_03" src="<c:out value="${ttsp.hinh}"></c:out>">
								</div>
							</div>
							<div class="products-description">
								<h5 class="name">
									<c:out value="${ttsp.tenSanPham}"></c:out>
								</h5>
								<p>
									<img alt="" src="images/star.png"> <a class="review_num"
										href="#"> 02 Review(s) </a>
								</p>
								<p>Mô tả:</p>
								<p>
									<c:out value="${ttsp.moTa}"></c:out>
								</p>
								<hr class="border">
								<div class="price">
									Giá : <span class="new_price"> <c:out
											value="${ttsp.gia}"></c:out> <sup> VND </sup>
									</span> <span class="old_price"> <c:out value="${ttsp.gia}"></c:out>
										<sup> VND </sup>
									</span>
								</div>
								<hr class="border">
								<div class="wided">
									<div class="qty">
										Số lượng &nbsp;&nbsp;: <select>
											<option>1</option>
										</select>
									</div>
									<div class="button_group">
										<a href="ThemGioHang?id=<c:out value="${ttsp.maSanPham}"/>">
											<button class="button">Thêm vào giỏ hàng</button>
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
		<!-- footer -->
		<%@ include file="footer.jsp"%>
	</div>
	<script type="text/javascript" src="resources/js/jquery-1.10.2.min.js">		
	</script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js">		
	</script>
	<script defer src="resources/js/jquery.flexslider.js">		
	</script>
	<script type="text/javascript"
		src="resources/js/jquery.carouFredSel-6.2.1-packed.js">		
	</script>
	<script type="text/javascript" src='resources/js/jquery.elevatezoom.js'>		
	</script>
	<script type="text/javascript" src="resources/js/script.min.js">		
	</script>
</body>
</html>