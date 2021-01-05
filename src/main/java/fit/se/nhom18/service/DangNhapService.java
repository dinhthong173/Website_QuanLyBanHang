package fit.se.nhom18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fit.se.nhom18.dao.NguoiDungDAO;
import fit.se.nhom18.model.NguoiDung;


@Service
@Transactional
public class DangNhapService {

	@Autowired
	NguoiDungDAO nguoiDungDAO;
	
	public NguoiDung getNguoiDungbyUsername(String username) {
		return nguoiDungDAO.getNguoiDungFindByUsername(username);
	}
}
