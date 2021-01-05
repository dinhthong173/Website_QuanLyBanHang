<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-sm-2">
				<div class="logo">
					<a href="/nhom18"><img
						src="resources/images/HinhWebsite/logo.png" alt="My Shop"></a>
				</div>
			</div>
			<div class="col-md-10 col-sm-10">
				<div class="header_top">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-9">
							<%if (session.getAttribute("user") != null) {%>
							<ul class="usermenu">
								<li>
									<div>
										<span style="color: white; font-size: 16px;"> <a
											href="ThongTinCaNhan" class="log"> <%=session.getAttribute("user") %>
										</a>
										</span>
									</div>
								</li>
								<li><a href="DangXuat">Đăng xuất</a></li>
							</ul>
							<%} else{ %>
							<ul class="usermenu">
								<li><a href="DangNhap" class="log">Đăng Nhập</a></li>
								<li><a href="DangKy" class="reg">Đăng ký</a></li>
							</ul>
							<%} %>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="header_bottom">

					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="<c:url value="/" />">Trang Chủ</a></li>
							<li><a href="ThongTinGioHang">Giỏ Hàng</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Danh Mục</a>
								<div class="dropdown-menu mega-menu">
									<div class="row">
										<div class="col-md-6 col-sm-6">
											<ul class="mega-menu-links">
												<c:forEach items="${sessionScope.dsdm}" var="dm">
													<li><a
														href="DanhMucSanPham?id=<c:out value="${dm.maDanhMuc}"/>">
															<c:out value="${dm.tenDanhMuc}" />
													</a></li>
												</c:forEach>
											</ul>
										</div>

									</div>
								</div></li>
<!-- 							<li style="color: white;"><form action="QuanLySanPham_TimTen" method="post" class="timkiem"> -->
<!-- 											<h5> -->
<!-- 												Tìm theo tên SP: <input type="text" name="tkten"> <input -->
<!-- 													type="submit" value="Tìm kiếm" class="btn btn-info"> -->
<!-- 											</h5> -->
<!-- 										</form></li> -->
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>