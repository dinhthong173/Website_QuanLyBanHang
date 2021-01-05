package fit.se.nhom18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.se.nhom18.dao.ChiTietDonHangDAO;
import fit.se.nhom18.dao.DonHangDAO;
import fit.se.nhom18.dao.NguoiDungDAO;
import fit.se.nhom18.dao.SanPhamDAO;
import fit.se.nhom18.model.ChiTietDonHang;
import fit.se.nhom18.model.DonHang;
import fit.se.nhom18.model.NguoiDung;
import fit.se.nhom18.model.SanPham;


@Service
@Transactional
public class GioHangService {
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	@Autowired
	private DonHangDAO donHangDAO;
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Autowired
	private ChiTietDonHangDAO chiTietDonHangDAO;
	
	public NguoiDung findNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
	
	public DonHang saveDonHang(DonHang donHang) {
		return donHangDAO.persistDonHang(donHang);
	}
	
	public SanPham getSanPhambyMaSanPham(int maSanPham) {
		return sanPhamDAO.getSanPhamFindByMaSanPham(maSanPham);
	}
	public void saveChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		chiTietDonHangDAO.persistChiTietDonHang(chiTietDonHang);
	}
	public List<DonHang> getAllDonHang(){
		return donHangDAO.getDonHangFindAll();
	}
}
