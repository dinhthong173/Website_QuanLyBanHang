package fit.se.nhom18.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fit.se.nhom18.model.ChiTietDonHang;
import fit.se.nhom18.model.SanPham;
import fit.se.nhom18.service.HomeService;


@Controller
public class ThemGioHang {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/ThemGioHang")
	public String ThongTinGioHang(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		SanPham sp = homeService.findSanPhambyID(id);
		
		if(sp.getSoLuong() < 1) {
			 out.println("alert('Sản phẩm đã hết hàng.');");
		}else {
			List<ChiTietDonHang> dsDH = (List<ChiTietDonHang>) session.getAttribute("cart");
			
			if(dsDH == null) {
				 dsDH = new ArrayList<ChiTietDonHang>();
					session.setAttribute("cart", dsDH);
			}
			for (ChiTietDonHang ctdt: dsDH) {
				if (ctdt.getSanPham().getMaSanPham()==id) {
					ctdt.setSoLuongSanPham(ctdt.getSoLuongSanPham()+1);
					return "redirect:ThongTinGioHang";
				}
			}
			
			ChiTietDonHang ct = new ChiTietDonHang(sp, 1, sp.getGia());
			
			dsDH.add(ct);
			
			session.setAttribute("cart", dsDH);
			
			return "redirect:ThongTinGioHang";
		}
		
		return "redirect:ThongTinGioHang";

	}
}
