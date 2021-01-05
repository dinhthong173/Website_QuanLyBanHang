package fit.se.nhom18.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fit.se.nhom18.model.ChiTietDonHang;
import fit.se.nhom18.model.DanhMuc;
import fit.se.nhom18.model.DonHang;
import fit.se.nhom18.model.MyFile;
import fit.se.nhom18.model.NguoiDung;
import fit.se.nhom18.model.SanPham;
import fit.se.nhom18.service.QuanLyService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50) // 50MB
@Controller
public class QuanLyController {
	@Autowired
	private QuanLyService quanLyService;
	@RequestMapping(value = "/QuanLyDonHang", method = RequestMethod.GET)
	public String quanlydonhang(ModelMap model, HttpSession session) {
		if (session.getAttribute("admin") == null) {
			return "redirect:DangNhap";
		}
		if (session.getAttribute("admin") != null) {
			List<DonHang> donHangsCu = quanLyService.getAllDonHangCu();
			List<DonHang> donHangsMoi = quanLyService.getAllDonHangMoi();
			model.addAttribute("dsdhtrue", donHangsCu);
			model.addAttribute("dsdhfalse", donHangsMoi);
			return "QuanLyDonHang";
		} else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/QuanLyDonHangXacNhan", method = RequestMethod.POST)
	public String quanlydonhangxacnhan(HttpSession session, ModelMap model,
			@RequestParam(name = "ma", required = true) int maDonHang) throws IOException {
		if (session.getAttribute("admin") != null) {
			DonHang donHang2 = quanLyService.getDonHangByMaDonHang(maDonHang);
			donHang2.setTinhTrangDonHang(1);
			quanLyService.updateDonHang(donHang2);
			return "redirect:QuanLyDonHang";
		} else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/QuanLyDonHangHuy", method = RequestMethod.POST)
	public String quanlydonhanghuy(HttpSession session, ModelMap model,
			@RequestParam(name = "ma", required = true) int maDonHang) throws IOException {
		if (session.getAttribute("admin") != null) {
			DonHang donHang = quanLyService.getDonHangByMaDonHang(maDonHang);
			donHang.setTinhTrangDonHang(0);
			quanLyService.updateDonHang(donHang);
			return "redirect:QuanLyDonHang";
		} else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/QuanLySanPham")
	public String quanlysanpham(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(name = "tbloi", required = false) String tb) throws UnsupportedEncodingException {
		if (session.getAttribute("admin") == null) {
			return "redirect:DangNhap";
		}
		if (session.getAttribute("admin") != null) {
			List<SanPham> phams = quanLyService.getAllSanPhamByTinhTrang(true);
			List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
			model.addAttribute("dssp", phams);
			model.addAttribute("dsdm", danhMucs);
			model.addAttribute("sanpham", new SanPham());
			model.addAttribute("thongbao", tb);
			model.addAttribute("myFile", new MyFile());
			request.setCharacterEncoding("utf-8");
			return "QuanLySanPham";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value="/ThemSanPham", method = RequestMethod.POST)
	public RedirectView themsanpham(@RequestParam CommonsMultipartFile file, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
		if(session.getAttribute("admin") != null){
			String fileName = file.getOriginalFilename();							
				
			SanPham sanPham = new SanPham();
			sanPham.setTenSanPham(request.getParameter("tensanpham"));
			sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
			sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
			sanPham.setMoTa(request.getParameter("mota"));
			sanPham.setHinh("resources/images/HinhSanPham/" + fileName);
			DanhMuc danhMuc =  quanLyService.getDanhMucByMa(Integer.parseInt(request.getParameter("madanhmuc")));
			sanPham.setMaDanhMuc(danhMuc);
			sanPham.setTinhTrang(true);
			
			quanLyService.ThemSanPham(sanPham);
			request.setAttribute("thongbao", "Thêm sản phẩm thành công");
			return new RedirectView("QuanLySanPham");
		}		
		return new RedirectView("DangNhap");
	}
	
	@RequestMapping(value = "/QuanLySanPham_LuuSanPhamSua", method = RequestMethod.POST)
	public RedirectView LuuSanPhamSua(@RequestParam CommonsMultipartFile file, HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes)
			throws IllegalStateException, IOException {
		String fileName = file.getOriginalFilename();
		
		if (session.getAttribute("admin") != null) {									
			SanPham sanPham = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("masanpham")));
			sanPham.setTenSanPham(request.getParameter("tensanpham"));
			sanPham.setGia(Integer.parseInt(request.getParameter("gia")));
			sanPham.setSoLuong(Integer.parseInt(request.getParameter("soluong")));
			sanPham.setMoTa(request.getParameter("mota"));
			if(!fileName.equalsIgnoreCase("")) {
				sanPham.setHinh("resources/images/HinhSanPham/" + fileName);
			}
			DanhMuc danhMuc = quanLyService.getDanhMucByMa(Integer.parseInt(request.getParameter("madanhmuc")));
			sanPham.setMaDanhMuc(danhMuc);
			quanLyService.UpdateSanPham(sanPham);
			return new RedirectView("QuanLySanPham");
		} else {
			return new RedirectView("/");
		}
	}

	@RequestMapping(value = "/XoaSanPham_QuanLy")
	public RedirectView XoaSanPham_QuanLy(HttpSession session, HttpServletRequest request) throws IOException {
		if (session.getAttribute("admin") != null) {
			List<ChiTietDonHang> list = quanLyService.getAllChiTietDonHang();
			boolean dinhchum = false;
			for (ChiTietDonHang ct : list) {
				if (ct.getSanPham().getMaSanPham() == Integer.parseInt(request.getParameter("id"))) {
					dinhchum = true;
				}
			}
			if (dinhchum == false) {
				SanPham sanPhamXoa = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
				quanLyService.XoaSanPham(sanPhamXoa);
				return new RedirectView("QuanLySanPham");
			} else {
				SanPham sanPhamXoa = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
				sanPhamXoa.setTinhTrang(false);
				quanLyService.UpdateSanPham(sanPhamXoa);
				return new RedirectView("QuanLySanPham");
			}
		} else {
			return new RedirectView("/");
		}
	}
	@RequestMapping(value = "/QuanLySanPham_TimTen")
	public String TimKiemTheoTen(Model model, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			String ten = request.getParameter("tkten");
			if (ten == "") {
				return "redirect:QuanLySanPham";
			} else {
				List<SanPham> phams = quanLyService.getAllSanPhamByTinhTrang(true);
				ArrayList<SanPham> listNew = new ArrayList<SanPham>();
				Pattern pattern = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
				for (SanPham sp : phams) {
					Matcher matcher = pattern.matcher(sp.getTenSanPham());
					if (matcher.find())
						listNew.add(sp);
				}
				model.addAttribute("dssp", listNew);
				List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
				model.addAttribute("dsdm", danhMucs);
				model.addAttribute("sanpham", new SanPham());
				return "QuanLySanPham";
			}
		} else {
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/SanPham_TimTen")
	public String TimKiemSanPham(Model model, HttpServletRequest request, HttpSession session) {
		
			String ten = request.getParameter("tkten");
			if (ten == "") {
				return "redirect:QuanLySanPham";
			} else {
				List<SanPham> phams = quanLyService.getAllSanPhamByTinhTrang(true);
				ArrayList<SanPham> listNew = new ArrayList<SanPham>();
				Pattern pattern = Pattern.compile(ten, Pattern.CASE_INSENSITIVE);
				for (SanPham sp : phams) {
					Matcher matcher = pattern.matcher(sp.getTenSanPham());
					if (matcher.find())
						listNew.add(sp);
				}
				model.addAttribute("dssp", listNew);
				List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
				model.addAttribute("dsdm", danhMucs);
				model.addAttribute("sanpham", new SanPham());
				return "QuanLySanPham";
			}
	}

	@RequestMapping(value = "/QuanLySanPham_TimDanhMuc")
	public String TimKiemTheoDanhMuc(Model model, HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			if (request.getParameter("madanhmuc").equals("all")) {
				return "redirect:QuanLySanPham";
			} else {
				int madm = Integer.parseInt(request.getParameter("madanhmuc"));
				List<SanPham> sanPhams = quanLyService.getAllSanPhamByTinhTrang(true);
				List<SanPham> listNew = new ArrayList<SanPham>();
				for (SanPham ss : sanPhams) {
					System.out.println(ss.getMaDanhMuc().getMaDanhMuc() + ">>>");
					if (ss.getMaDanhMuc().getMaDanhMuc() == madm) {
						listNew.add(ss);
					}
				}
				model.addAttribute("dssp", listNew);
				List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
				model.addAttribute("dsdm", danhMucs);
				model.addAttribute("sanpham", new SanPham());
				return "QuanLySanPham";
			}
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/QuanLySanPham_SuaSanPham")
	public String SuaSanPham(HttpSession session, Model model, HttpServletRequest request) throws IOException {
		if (session.getAttribute("admin") != null) {
			SanPham sanPham = quanLyService.getSanPhamByMa(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("ttsp", sanPham);
			List<DanhMuc> danhMucs = quanLyService.getAllDanhMuc();
			request.setAttribute("dsdm", danhMucs);
			model.addAttribute("myFile", new MyFile());
			return "SuaThongTinSanPham";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/QuanLyNguoiDung")
	public String quanlynguoidung(ModelMap map, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			List<NguoiDung> dungs = quanLyService.getAllNguoiDung();
			map.addAttribute("dsnd", dungs);
			return "QuanLyNguoiDung";
		} else {
			return "redirect:/";
		}
	}

}
