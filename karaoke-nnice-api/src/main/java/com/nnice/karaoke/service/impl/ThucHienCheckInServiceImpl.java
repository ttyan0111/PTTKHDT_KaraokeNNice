package com.nnice.karaoke.service.impl;

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
    public Optional<PhieuSuDung> traCuuPhieuDatPhong(String maDat) {
        return phieuSuDungRepository.findAll().stream()
                .filter(p -> p.getMaPhieuDat().toString().equals(maDat))
                .findFirst();
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
    public PhieuSuDung thucHienCheckIn(Integer maPhieu, LocalDateTime thoiGianVao) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(maPhieu);
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            p.setGioBatDau(thoiGianVao);
            p.setTrangThai("Đang sử dụng");
            return phieuSuDungRepository.save(p);
        }
        return null;
    }
    
    @Override
    public PhieuSuDung thucHienCheckOut(Integer maPhieu, LocalDateTime thoiGianRa) {
        Optional<PhieuSuDung> phieu = phieuSuDungRepository.findById(maPhieu);
        if (phieu.isPresent()) {
            PhieuSuDung p = phieu.get();
            p.setGioKetThuc(thoiGianRa);
            p.setTrangThai("Đã thanh toán");
            return phieuSuDungRepository.save(p);
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
    public PhieuSuDung xuLyKhachVangLai(Integer maPhong, int soNguoi, LocalDateTime thoiGianVao) {
        PhieuSuDung phieu = new PhieuSuDung();
        phieu.setGioBatDau(thoiGianVao);
        phieu.setTrangThai("Đang sử dụng");
        return phieuSuDungRepository.save(phieu);
    }
    
    @Override
    public boolean kiemTraPhongTrong(Integer maPhong) {
        return true; // TODO: Implement real logic
    }
}
