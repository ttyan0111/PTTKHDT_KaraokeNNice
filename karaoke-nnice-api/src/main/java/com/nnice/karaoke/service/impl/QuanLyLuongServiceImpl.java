package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.BangLuong;
import com.nnice.karaoke.repository.BangLuongRepository;
import com.nnice.karaoke.service.QuanLyLuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyLuongServiceImpl implements QuanLyLuongService {
    
    @Autowired
    private BangLuongRepository bangLuongRepository;
    
    @Override
    public BangLuong tinhLuongNhanVien(Integer maNhanVien, int thang, int nam) {
        BangLuong bangLuong = new BangLuong();
        return bangLuongRepository.save(bangLuong);
    }
    
    @Override
    public Long tinhLuongCoBan(Integer maNhanVien, int soCa) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhThuongDoanhThu(Integer maNhanVien, Long doanhThuCoso) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhPhuCap(Integer maNhanVien, int thang, int nam) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhKhoanTru(Integer maNhanVien, int thang, int nam) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhTongLuong(Integer maNhanVien, int thang, int nam) {
        Long luongCoBan = tinhLuongCoBan(maNhanVien, 0);
        Long thuong = tinhThuongDoanhThu(maNhanVien, 0L);
        Long phuCap = tinhPhuCap(maNhanVien, thang, nam);
        Long khoanTru = tinhKhoanTru(maNhanVien, thang, nam);
        
        return luongCoBan + thuong + phuCap - khoanTru;
    }
    
    @Override
    public Optional<BangLuong> xemChiTiet(Integer maNhanVien, int thang, int nam) {
        return bangLuongRepository.findAll().stream().findFirst();
    }
    
    @Override
    public BangLuong capNhatLuong(BangLuong bangLuong) {
        return bangLuongRepository.save(bangLuong);
    }
    
    @Override
    public void pheDuyetBangLuong(Integer maNhanVien, int thang, int nam) {
        // TODO: Implement
    }
    
    @Override
    public void inPhieuLuong(Integer maNhanVien, int thang, int nam) {
        // TODO: Implement
    }
    
    @Override
    public List<BangLuong> danhSachLuongThang(int thang, int nam) {
        return bangLuongRepository.findAll();
    }
}
