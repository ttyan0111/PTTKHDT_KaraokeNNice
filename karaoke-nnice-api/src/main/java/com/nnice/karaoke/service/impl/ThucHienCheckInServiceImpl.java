package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.request.CheckInRequest;
import com.nnice.karaoke.dto.request.CheckOutRequest;
import com.nnice.karaoke.dto.response.CheckInResponse;
import com.nnice.karaoke.dto.response.CheckOutResponse;
import com.nnice.karaoke.entity.PhieuSuDung;
import com.nnice.karaoke.repository.PhieuSuDungRepository;
import com.nnice.karaoke.service.ThucHienCheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ThucHienCheckInServiceImpl implements ThucHienCheckInService {
    
    @Autowired
    private PhieuSuDungRepository phieuSuDungRepository;
    
    private static final long GIA_NGAY = 25000L;
    private static final long GIA_DEM = 45000L;
    
    @Override
    public CheckInResponse traCuuPhieuDatPhong(String maDat) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findAll().stream()
                .filter(p -> p.getPhieuDatPhong() != null && p.getPhieuDatPhong().getMaPhieuDat().toString().equals(maDat))
                .findFirst();
        return phieu.map(this::convertToCheckInResponse).orElse(null);
    }
    
    @Override
    public void xacNhanThongTinKhach(Integer maPhieu, String soCMND, int soNguoiThuc) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(maPhieu);
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            phieuSuDungRepository.save(p);
        }
    }
    
    @Override
    public CheckInResponse thucHienCheckIn(CheckInRequest request) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(request.getMaPhieuDat());
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            p.setGioBatDau(LocalDateTime.now());
            p.setTrangThai("Dang su dung");
            PhieuSuDung saved = phieuSuDungRepository.save(p);
            return convertToCheckInResponse(saved);
        }
        return null;
    }
    
    @Override
    public CheckOutResponse thucHienCheckOut(CheckOutRequest request) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(request.getMaPhieuSuDung());
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            p.setGioKetThuc(LocalDateTime.now());
            p.setTrangThai("Da thanh toan");
            PhieuSuDung saved = phieuSuDungRepository.save(p);
            return convertToCheckOutResponse(saved);
        }
        return null;
    }
    
    @Override
    public Long tinhTienThucTe(Integer maPhieu, LocalDateTime thoiGianRa) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(maPhieu);
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            if (p.getGioBatDau() != null) {
                long gioSuDung = java.time.temporal.ChronoUnit.HOURS.between(p.getGioBatDau(), thoiGianRa);
                int gioVao = p.getGioBatDau().getHour();
                
                if (gioVao >= 8 && gioVao < 18) {
                    return gioSuDung * GIA_NGAY;
                } else {
                    return gioSuDung * GIA_DEM;
                }
            }
        }
        return 0L;
    }
    
    @Override
    public CheckInResponse xuLyKhachVangLai(Integer maPhong, int soNguoi, LocalDateTime thoiGianVao) {
        PhieuSuDung phieu = new PhieuSuDung();
        phieu.setGioBatDau(thoiGianVao);
        phieu.setTrangThai("Dang su dung");
        PhieuSuDung saved = phieuSuDungRepository.save(phieu);
        return convertToCheckInResponse(saved);
    }
    
    @Override
    public boolean kiemTraPhongTrong(Integer maPhong) {
        return true; // TODO: Implement real logic
    }
    
    private CheckInResponse convertToCheckInResponse(PhieuSuDung phieu) {
        return CheckInResponse.builder()
                .maPhieuSuDung(phieu.getMaPhieuSuDung())
                .maPhong(phieu.getPhong() != null ? phieu.getPhong().getMaPhong() : null)
                .thoiGianCheckIn(phieu.getGioBatDau())
                .trangThai(phieu.getTrangThai())
                .build();
    }
    
    private CheckOutResponse convertToCheckOutResponse(PhieuSuDung phieu) {
        return CheckOutResponse.builder()
                .maPhieuSuDung(phieu.getMaPhieuSuDung())
                .maPhong(phieu.getPhong() != null ? phieu.getPhong().getMaPhong() : null)
                .gioBatDau(phieu.getGioBatDau())
                .gioKetThuc(phieu.getGioKetThuc())
                .trangThai(phieu.getTrangThai())
                .build();
    }
}
