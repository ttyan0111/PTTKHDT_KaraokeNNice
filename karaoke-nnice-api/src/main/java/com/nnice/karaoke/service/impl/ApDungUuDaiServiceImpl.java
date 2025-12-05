package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.CauHinhGia;
import com.nnice.karaoke.repository.CauHinhGiaRepository;
import com.nnice.karaoke.service.ApDungUuDaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApDungUuDaiServiceImpl implements ApDungUuDaiService {
    
    @Autowired
    private CauHinhGiaRepository cauHinhGiaRepository;
    
    @Override
    public Optional<CauHinhGia> kiemTraUuDai(String maUuDai) {
        return cauHinhGiaRepository.findAll().stream()
                .filter(c -> c.getMaCauHinh().toString().equals(maUuDai))
                .findFirst();
    }
    
    @Override
    public boolean kiemTraUuDaiConHan(Integer maUuDai) {
        return true; // TODO: Implement
    }
    
    @Override
    public boolean kiemTraChuaSuDung(Integer maUuDai) {
        return true; // TODO: Implement
    }
    
    @Override
    public Long apDungGiamGiaPercent(Long tongTien, Integer phanTram) {
        return tongTien - (tongTien * phanTram / 100);
    }
    
    @Override
    public Long apDungGiamGiaCoDinh(Long tongTien, Long soTienGiam) {
        return Math.max(0, tongTien - soTienGiam);
    }
    
    @Override
    public Long tinhTienGiam(Long tongTien, Integer maUuDai) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public void danhDauDaSuDung(Integer maUuDai) {
        // TODO: Implement
    }
    
    @Override
    public List<CauHinhGia> danhSachUuDaiConHan() {
        return cauHinhGiaRepository.findAll(); // TODO: Filter by han su dung
    }
}
