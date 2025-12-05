package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.PhieuNhap;
import com.nnice.karaoke.repository.PhieuNhapRepository;
import com.nnice.karaoke.service.QuanLyNhapKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyNhapKhoServiceImpl implements QuanLyNhapKhoService {
    
    @Autowired
    private PhieuNhapRepository phieuNhapRepository;
    
    @Override
    public PhieuNhap taoPhieuNhap(PhieuNhap phieuNhap) {
        return phieuNhapRepository.save(phieuNhap);
    }
    
    @Override
    public Optional<PhieuNhap> xemChiTiet(Integer maPhieu) {
        return phieuNhapRepository.findById(maPhieu);
    }
    
    @Override
    public PhieuNhap capNhatPhieuNhap(PhieuNhap phieuNhap) {
        return phieuNhapRepository.save(phieuNhap);
    }
    
    @Override
    public Long tinhTongGiaTriPhieu(Integer maPhieu) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public void capNhatTonKho(Integer maMatHang, int soLuong) {
        // TODO: Implement
    }
    
    @Override
    public List<PhieuNhap> danhSachPhieuNhap() {
        return phieuNhapRepository.findAll();
    }
    
    @Override
    public List<PhieuNhap> danhSachTheoNhaCungCap(Integer maNhaCungCap) {
        return phieuNhapRepository.findAll();
    }
}
