package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.CauHinhGia;
import com.nnice.karaoke.repository.CauHinhGiaRepository;
import com.nnice.karaoke.service.QuanLyCauHinhHeThongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyCauHinhHeThongServiceImpl implements QuanLyCauHinhHeThongService {
    
    @Autowired
    private CauHinhGiaRepository cauHinhGiaRepository;
    
    @Override
    public CauHinhGia cauHinhGiaPhong(Long giaNgay, Long giaDem) {
        CauHinhGia cauHinh = new CauHinhGia();
        return cauHinhGiaRepository.save(cauHinh);
    }
    
    @Override
    public void cauHinhDichVu(String tenDichVu, Long giaDichVu) {
        // TODO: Implement
    }
    
    @Override
    public void cauHinhChamCong(String cauHinh, Object giaTriCauHinh) {
        // TODO: Implement
    }
    
    @Override
    public void cauHinhThanhVien(String cauHinh, Object giaTriCauHinh) {
        // TODO: Implement
    }
    
    @Override
    public void cauHinhThanhToan(String hinhThucThanhToan, boolean active) {
        // TODO: Implement
    }
    
    @Override
    public Optional<CauHinhGia> xemCauHinhHienTai(String loaiCauHinh) {
        return cauHinhGiaRepository.findAll().stream().findFirst();
    }
    
    @Override
    public CauHinhGia capNhatCauHinh(CauHinhGia cauHinhGia) {
        return cauHinhGiaRepository.save(cauHinhGia);
    }
    
    @Override
    public List<CauHinhGia> danhSachCauHinh() {
        return cauHinhGiaRepository.findAll();
    }
}
