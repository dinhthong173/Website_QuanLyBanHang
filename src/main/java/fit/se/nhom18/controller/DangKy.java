package fit.se.nhom18.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fit.se.nhom18.model.NguoiDung;
import fit.se.nhom18.service.DangKyService;

@Controller
public class DangKy {

	@Autowired
	DangKyService dangKyService;
	
	@RequestMapping(value="/DangKy", method = RequestMethod.GET)
	public String DangKy() {
		return "DangKy";
	}
	
	@RequestMapping(value="/DangKy", method = RequestMethod.POST)
	public String DangKy(HttpServletRequest request, @ModelAttribute("nguoidung") NguoiDung nd) {
		String passconfirm = request.getParameter("passwordconfirm");
		try {
			dangKyService.getNguoiDungbyUsername(nd.getUsername());
			request.setAttribute("thongbao", "Tên đăng nhập đã tồn tại, vui lòng dùng tên đăng nhập khác.");
			return "DangKy";
		}catch (Exception e) {
			// TODO: handle exception
			if (!nd.getPass().equals(passconfirm)) {
				request.setAttribute("thongbao", "Mật khẩu nhập lại không khớp với nhau, hãy thử lại.");
				return "DangKy";
			} else {
				dangKyService.saveNguoiDung(nd);
				request.setAttribute("thongbao", "Đăng ký thành công. Đăng nhập để mua hàng!");
				return "DangNhap";
			}
		}	
	}
}
