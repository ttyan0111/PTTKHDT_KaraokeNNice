package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.PhieuXuat;
import com.nnice.karaoke.repository.PhieuXuatRepository;
import com.nnice.karaoke.service.QuanLyXuatKhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyXuatKhoServiceImpl implements QuanLyXuatKhoService {
    
    @Autowired
    private PhieuXuatRepository phieuXuatRepository;
    
    @Override
    public PhieuXuat taoPhieuXuat(PhieuXuat phieuXuat) {
        return phieuXuatRepository.save(phieuXuat);
    }
    
    @Override
    public Optional<PhieuXuat> xemChiTiet(Integer maPhieu) {
        return phieuXuatRepository.findById(maPhieu);
    }
    
    @Override
    public PhieuXuat capNhatPhieuXuat(PhieuXuat phieuXuat) {
        return phieuXuatRepository.save(phieuXuat);
    }
    
    @Override
    public boolean kiemTraTonKho(Integer maMatHang, int soLuong) {
        return true; // TODO: Implement
    }
    
    @Override
    public void truTonKho(Integer maMatHang, int soLuong) {
        // TODO: Implement
    }
    
    @Override
    public void xuatKhoTheoOrder(Integer maOrder) {
        // TODO: Implement
    }
    
    @Override
    public List<PhieuXuat> danhSachPhieuXuat() {
        return phieuXuatRepository.findAll();
    }
    
    @Override
    public List<PhieuXuat> danhSachTheoBoPhan(String boPhan) {
        return phieuXuatRepository.findAll();
    }
}
