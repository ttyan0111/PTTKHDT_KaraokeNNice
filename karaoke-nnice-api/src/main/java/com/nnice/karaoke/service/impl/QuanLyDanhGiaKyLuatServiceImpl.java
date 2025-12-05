package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.NhanVien;
import com.nnice.karaoke.repository.NhanVienRepository;
import com.nnice.karaoke.service.QuanLyDanhGiaKyLuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyDanhGiaKyLuatServiceImpl implements QuanLyDanhGiaKyLuatService {
    
    @Autowired
    private NhanVienRepository nhanVienRepository;
    
    @Override
    public void danhGiaDinhKy(Integer maNhanVien, String thaiDo, String chuyenMon, String kyLuat) {
        // TODO: Implement
    }
    
    @Override
    public void khenThuong(Integer maNhanVien, String loaiThuong, Long soTien, String ghiChu) {
        // TODO: Implement
    }
    
    @Override
    public void kyLuat(Integer maNhanVien, String loaiKyLuat, Long soTienPhat, String ghiChu) {
        // TODO: Implement
    }
    
    @Override
    public void luuVaoHoSo(Integer maNhanVien, String noNoi) {
        // TODO: Implement
    }
    
    @Override
    public List<Object> xemLichSuKhenThuongKyLuat(Integer maNhanVien) {
        return new ArrayList<>(); // TODO: Implement
    }
    
    @Override
    public void capNhatANhHuongLuong(Integer maNhanVien) {
        // TODO: Implement
    }
    
    @Override
    public List<NhanVien> danhSachNhanVienViPham() {
        return new ArrayList<>(); // TODO: Implement
    }
}
