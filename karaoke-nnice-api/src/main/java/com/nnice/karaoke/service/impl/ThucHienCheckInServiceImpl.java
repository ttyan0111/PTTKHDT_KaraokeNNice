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

@Service
public class ThucHienCheckInServiceImpl implements ThucHienCheckInService {
    
    @Autowired
    private PhieuSuDungRepository phieuSuDungRepository;
    
    private static final long GIA_NGAY = 25000L;
    private static final long GIA_DEM = 45000L;
    
    @Override
    public CheckInResponse traCuuPhieuDatPhong(String maDat) {
        if (maDat == null) {
            throw new RuntimeException("MaDat cannot be null");
        }
        PhieuSuDung phieu = phieuSuDungRepository.findAll().stream()
                .filter(p -> p.getPhieuDatPhong() != null && p.getPhieuDatPhong().getMaPhieuDat().toString().equals(maDat))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with MaDat: " + maDat));
        return convertToCheckInResponse(phieu);
    }
    
    @Override
    public void xacNhanThongTinKhach(Integer maPhieu, String soCMND, int soNguoiThuc) {
        if (maPhieu == null) {
            throw new RuntimeException("MaPhieu cannot be null");
        }
        PhieuSuDung p = phieuSuDungRepository.findById(maPhieu)
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with id: " + maPhieu));
        phieuSuDungRepository.save(p);
    }
    
    @Override
    public CheckInResponse thucHienCheckIn(CheckInRequest request) {
        if (request == null || request.getMaPhieuDat() == null) {
            throw new RuntimeException("CheckInRequest and MaPhieuDat cannot be null");
        }
        PhieuSuDung p = phieuSuDungRepository.findById(request.getMaPhieuDat())
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with id: " + request.getMaPhieuDat()));
        p.setGioBatDau(LocalDateTime.now());
        p.setTrangThai("Dang su dung");
        PhieuSuDung saved = phieuSuDungRepository.save(p);
        return convertToCheckInResponse(saved);
    }
    
    @Override
    public CheckOutResponse thucHienCheckOut(CheckOutRequest request) {
        if (request == null || request.getMaPhieuSuDung() == null) {
            throw new RuntimeException("CheckOutRequest and MaPhieuSuDung cannot be null");
        }
        PhieuSuDung p = phieuSuDungRepository.findById(request.getMaPhieuSuDung())
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with id: " + request.getMaPhieuSuDung()));
        p.setGioKetThuc(LocalDateTime.now());
        p.setTrangThai("Da thanh toan");
        PhieuSuDung saved = phieuSuDungRepository.save(p);
        return convertToCheckOutResponse(saved);
    }
    
    @Override
    public Long tinhTienThucTe(Integer maPhieu, LocalDateTime thoiGianRa) {
        if (maPhieu == null || thoiGianRa == null) {
            throw new RuntimeException("MaPhieu and ThoiGianRa cannot be null");
        }
        PhieuSuDung p = phieuSuDungRepository.findById(maPhieu)
                .orElseThrow(() -> new RuntimeException("PhieuSuDung not found with id: " + maPhieu));
        if (p.getGioBatDau() != null) {
            long gioSuDung = java.time.temporal.ChronoUnit.HOURS.between(p.getGioBatDau(), thoiGianRa);
            int gioVao = p.getGioBatDau().getHour();
            
            if (gioVao >= 8 && gioVao < 18) {
                return gioSuDung * GIA_NGAY;
            } else {
                return gioSuDung * GIA_DEM;
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
