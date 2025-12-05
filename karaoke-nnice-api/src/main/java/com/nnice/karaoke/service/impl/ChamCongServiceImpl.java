package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.BangChamCong;
import com.nnice.karaoke.repository.BangChamCongRepository;
import com.nnice.karaoke.service.ChamCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamCongServiceImpl implements ChamCongService {
    
    @Autowired
    private BangChamCongRepository bangChamCongRepository;
    
    @Override
    public BangChamCong checkIn(Integer maNhanVien, LocalDate ngayLamViec) {
        BangChamCong chamCong = new BangChamCong();
        return bangChamCongRepository.save(chamCong);
    }
    
    @Override
    public BangChamCong checkOut(Integer maNhanVien, LocalDate ngayLamViec) {
        BangChamCong chamCong = new BangChamCong();
        return bangChamCongRepository.save(chamCong);
    }
    
    @Override
    public void ghiNhanGPS(Integer maNhanVien, String viTri) {
        // TODO: Implement
    }
    
    @Override
    public String soSanhCaLamViec(Integer maNhanVien, LocalDate ngayLamViec) {
        return "Đúng giờ"; // TODO: Implement
    }
    
    @Override
    public void danhDauTrangThai(Integer maNhanVien, LocalDate ngayLamViec, String trangThai) {
        // TODO: Implement
    }
    
    @Override
    public Optional<BangChamCong> xemChiTiet(Integer maNhanVien, LocalDate ngayLamViec) {
        return bangChamCongRepository.findAll().stream().findFirst();
    }
    
    @Override
    public List<BangChamCong> danhSachThangLamViec(Integer maNhanVien, int thang, int nam) {
        return bangChamCongRepository.findAll();
    }
    
    @Override
    public List<BangChamCong> danhSachToanBoNhanVien(LocalDate ngayLamViec) {
        return bangChamCongRepository.findAll();
    }
}
