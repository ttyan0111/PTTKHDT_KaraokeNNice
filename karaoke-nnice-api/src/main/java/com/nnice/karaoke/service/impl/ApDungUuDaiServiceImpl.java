package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.response.ApDungUuDaiResponse;
import com.nnice.karaoke.repository.CauHinhGiaRepository;
import com.nnice.karaoke.service.ApDungUuDaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApDungUuDaiServiceImpl implements ApDungUuDaiService {
    
    @Autowired
    private CauHinhGiaRepository cauHinhGiaRepository;
    
    @Override
    public ApDungUuDaiResponse kiemTraUuDai(String maUuDai) {
        return cauHinhGiaRepository.findAll().stream()
                .filter(c -> c.getMaCauHinh().toString().equals(maUuDai))
                .findFirst()
                .map(c -> ApDungUuDaiResponse.builder()
                        .maCauHinh(c.getMaCauHinh())
                        .maLoai(c.getMaLoai())
                        .khungGio(c.getKhungGio())
                        .loaiNgay(c.getLoaiNgay())
                        .donGia(c.getDonGia())
                        .conHan(true) // TODO: Check expiry date
                        .daSuDung(false) // TODO: Check usage status
                        .tienGiam(c.getDonGia())
                        .build())
                .orElse(null); // hoặc throw exception nếu không tìm thấy
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
    public List<ApDungUuDaiResponse> danhSachUuDaiConHan() {
        return cauHinhGiaRepository.findAll()
                .stream()
                .map(c -> ApDungUuDaiResponse.builder()
                        .maCauHinh(c.getMaCauHinh())
                        .maLoai(c.getMaLoai())
                        .khungGio(c.getKhungGio())
                        .loaiNgay(c.getLoaiNgay())
                        .donGia(c.getDonGia())
                        .conHan(true) // TODO: Filter by han su dung
                        .daSuDung(false)
                        .tienGiam(c.getDonGia())
                        .build())
                .collect(Collectors.toList());
    }
}
