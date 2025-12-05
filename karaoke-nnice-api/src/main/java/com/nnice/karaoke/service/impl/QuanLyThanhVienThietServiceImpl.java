package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.KhachHang;
import com.nnice.karaoke.entity.TheThanhVien;
import com.nnice.karaoke.repository.KhachHangRepository;
import com.nnice.karaoke.repository.TheThanhVienRepository;
import com.nnice.karaoke.service.QuanLyThanhVienThietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyThanhVienThietServiceImpl implements QuanLyThanhVienThietService {
    
    @Autowired
    private TheThanhVienRepository theThanhVienRepository;
    
    @Autowired
    private KhachHangRepository khachHangRepository;
    
    @Override
    public TheThanhVien dangKyThanhVienMoi(KhachHang khachHang) {
        TheThanhVien tv = new TheThanhVien();
        theThanhVienRepository.save(tv);
        return tv;
    }
    
    @Override
    public String taoMaThanhVien() {
        return "TV" + System.currentTimeMillis();
    }
    
    @Override
    public Optional<TheThanhVien> traCuuThongTin(Integer maThanhVien) {
        return theThanhVienRepository.findById(maThanhVien);
    }
    
    @Override
    public Optional<TheThanhVien> traCuuTheoSDT(String sdt) {
        return theThanhVienRepository.findAll().stream()
                .findFirst();
    }
    
    @Override
    public TheThanhVien capNhatThongTin(TheThanhVien theThanhVien) {
        return theThanhVienRepository.save(theThanhVien);
    }
    
    @Override
    public void xemLichSu(Integer maThanhVien) {
        // TODO: Implement
    }
    
    @Override
    public void inThe(Integer maThanhVien) {
        // TODO: Implement
    }
    
    @Override
    public void guiSMSMaThanhVien(String sdt, String maThanhVien) {
        // TODO: Implement
    }
    
    @Override
    public List<TheThanhVien> danhSach() {
        return theThanhVienRepository.findAll();
    }
}
