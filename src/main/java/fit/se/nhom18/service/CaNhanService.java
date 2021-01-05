package fit.se.nhom18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.se.nhom18.dao.ChiTietDonHangDAO;
import fit.se.nhom18.dao.DonHangDAO;
import fit.se.nhom18.dao.NguoiDungDAO;
import fit.se.nhom18.model.ChiTietDonHang;
import fit.se.nhom18.model.DonHang;
import fit.se.nhom18.model.NguoiDung;


@Service
@Transactional
public class CaNhanService {

	@Autowired
	DonHangDAO donHangDAO;
	@Autowired
	NguoiDungDAO nguoiDungDAO;
	@Autowired
	ChiTietDonHangDAO chiTietDonHangDAO;
	
	public List<DonHang> getDonHangbyNguoiDung(NguoiDung nguoiDung) {
		return donHangDAO.getDonHangFindByNguoiDung(nguoiDung);
	}
	
	public NguoiDung getNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
	
	public NguoiDung updateNguoiDung(NguoiDung nguoiDung) {
		return nguoiDungDAO.mergeNguoiDung(nguoiDung);
	}
	
	public List<ChiTietDonHang> getChiTietDonHangbyMaDonHang(int maDonHang){
		return chiTietDonHangDAO.getChiTietDonHangFindByMaDonHang(maDonHang);
	}
}
