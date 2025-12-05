package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.service.PhanCongCaLamService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhanCongCaLamServiceImpl implements PhanCongCaLamService {
    
    @Override
    public void phanCongNhanVienVaoCa(Integer maNhanVien, Integer maCa, LocalDate ngayLamViec) {
        // TODO: Implement
    }
    
    @Override
    public boolean kiemTraKhongTrungCa(Integer maNhanVien, LocalDate ngayLamViec) {
        return true; // TODO: Implement
    }
    
    @Override
    public boolean kiemTraNhanVienKhongNghiPhep(Integer maNhanVien, LocalDate ngayLamViec) {
        return true; // TODO: Implement
    }
    
    @Override
    public void canhBaoThieuNguoi(LocalDate ngayLamViec, Integer maCa) {
        // TODO: Implement
    }
    
    @Override
    public List<Object> xemPhanCongTheoNgay(LocalDate ngayLamViec) {
        return new ArrayList<>(); // TODO: Implement
    }
    
    @Override
    public List<Object> xemPhanCongTheoCa(Integer maCa, LocalDate ngayLamViec) {
        return new ArrayList<>(); // TODO: Implement
    }
    
    @Override
    public void capNhatPhanCong(Integer maNhanVien, Integer caCu, Integer caMoi) {
        // TODO: Implement
    }
    
    @Override
    public void xoaPhanCong(Integer maNhanVien, LocalDate ngayLamViec) {
        // TODO: Implement
    }
}
