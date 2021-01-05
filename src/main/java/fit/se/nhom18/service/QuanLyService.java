package fit.se.nhom18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.se.nhom18.dao.ChiTietDonHangDAO;
import fit.se.nhom18.dao.DanhMucDAO;
import fit.se.nhom18.dao.DonHangDAO;
import fit.se.nhom18.dao.NguoiDungDAO;
import fit.se.nhom18.dao.SanPhamDAO;
import fit.se.nhom18.model.ChiTietDonHang;
import fit.se.nhom18.model.DanhMuc;
import fit.se.nhom18.model.DonHang;
import fit.se.nhom18.model.NguoiDung;
import fit.se.nhom18.model.SanPham;


@Service
@Transactional
public class QuanLyService {
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Autowired
	private NguoiDungDAO nguoiDungDAO;
	@Autowired
	private DonHangDAO donHangDAO;
	@Autowired
	private ChiTietDonHangDAO chiTietDonHangDAO;
	@Autowired
	private DanhMucDAO danhMucDAO;
	
	public List<DonHang> getAllDonHangCu(){
		return donHangDAO.getDonHangFindByTinhTrangDonHang(1);
	}
	public List<DonHang> getAllDonHangMoi(){
		return donHangDAO.getDonHangFindByTinhTrangDonHang(-1);
	}
	public List<SanPham> getAllSanPham(){
		return sanPhamDAO.getSanPhamFindAll();
	}
	public List<NguoiDung> getAllNguoiDung(){
		return nguoiDungDAO.getNguoiDungFindAll();
	}
	public List<ChiTietDonHang> getAllChiTietDonHang(){
		return chiTietDonHangDAO.getChiTietDonHangFindAll();
	}
	public List<ChiTietDonHang> getAllChiTietDonHangByMaDonHang(int maDonHang){
		return chiTietDonHangDAO.getChiTietDonHangFindByMaDonHang(maDonHang);
	}
	
	public void XoaCTDH(ChiTietDonHang chiTietDonHang) {
		chiTietDonHangDAO.removeChiTietDonHang(chiTietDonHang);
	}
	public List<DonHang> getAllDonHang(){
		return donHangDAO.getDonHangFindAll();
	}
	public DonHang getDonHangByMaDonHang(int maDonHang) {
		return donHangDAO.getDonHangFindByMaDonHang(maDonHang).get(0);
	}
	public void XoaDonHang(DonHang donHang) {
		donHangDAO.removeDonHang(donHang);
	}
	public void updateDonHang(DonHang donHang) {
		donHangDAO.mergeDonHang(donHang);
	}
	public List<DanhMuc> getAllDanhMuc(){
		return danhMucDAO.getDanhMucFindAll();
	}
	public SanPham getSanPhamByTen(String ten) {
		return sanPhamDAO.getSanPhamFindByTenSanPham(ten).get(0);
	}
	public SanPham getSanPhamByMa(int maSanPham) {
		return sanPhamDAO.getSanPhamFindByMaSanPham(maSanPham);
	}
	public List<SanPham> getAllSanPhamByTinhTrang(Boolean i) {
		return sanPhamDAO.getSanPhamFindByTinhTrang(i);
	}
	
	public void XoaSanPham(SanPham sanPham) {
		sanPhamDAO.removeSanPham(sanPham);
	}
	public DanhMuc getDanhMucByMa(int ma) {
		return danhMucDAO.getDanhMucFindByMaDanhMuc(ma);
	}
	public void LuuDanhMuc(DanhMuc danhMuc) {
		danhMucDAO.persistDanhMuc(danhMuc);
	}
	public void ThemSanPham(SanPham sanPham) {
		sanPhamDAO.persistSanPham(sanPham);
	}
	public void UpdateSanPham(SanPham sanPham) {
		sanPhamDAO.mergeSanPham(sanPham);
	}
}
