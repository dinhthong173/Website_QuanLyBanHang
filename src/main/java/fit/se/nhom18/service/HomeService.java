package fit.se.nhom18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.se.nhom18.dao.DanhMucDAO;
import fit.se.nhom18.dao.SanPhamDAO;
import fit.se.nhom18.model.DanhMuc;
import fit.se.nhom18.model.SanPham;


@Service
@Transactional
public class HomeService {
	@Autowired
	private SanPhamDAO sanPhamDAO;
	@Autowired
	private DanhMucDAO danhMucDAO;
	
	public List<SanPham> findAllSanPham(){
		return sanPhamDAO.getSanPhamFindAll();
	}
	//Dat ten Class khac ko dc a/ chung cho nó gọn rồi ai nhớ class nào ra class nào chỉ gần gọi tới service nó tự source ra mà
	public List<DanhMuc> findAllDanhMuc(){
		return danhMucDAO.getDanhMucFindAll();
	}
	
	public SanPham findSanPhambyID(int id) {
		return sanPhamDAO.getSanPhamFindByMaSanPham(id);
	}
	
	public List<SanPham> findSanPhambyDanhMuc(DanhMuc danhMuc){
		return sanPhamDAO.getSanPhamFindByDanhMuc(danhMuc);
	}
	
	public DanhMuc findDanhMucbyMaDanhMuc(int maDanhMuc) {
		return danhMucDAO.getDanhMucFindByMaDanhMuc(maDanhMuc);
	}
	
	public List<SanPham> getAllSanPhamByTinhTrang(boolean tinhTrang) {
		return sanPhamDAO.getSanPhamFindByTinhTrang(tinhTrang);
	}
}
