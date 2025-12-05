package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.entity.PhieuDatPhong;
import com.nnice.karaoke.entity.Phong;
import com.nnice.karaoke.entity.LoaiPhong;
import com.nnice.karaoke.repository.PhieuDatPhongRepository;
import com.nnice.karaoke.repository.PhongRepository;
import com.nnice.karaoke.repository.LoaiPhongRepository;
import com.nnice.karaoke.service.QuanLyDatPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    
    @Autowired
    private PhieuDatPhongRepository phieuDatPhongRepository;
    
    @Autowired
    private PhongRepository phongRepository;
    
    @Autowired
    private LoaiPhongRepository loaiPhongRepository;
    
    private static final long GIA_NGAY = 25000L; // 25,000đ/giờ (8h-18h)
    private static final long GIA_DEM = 45000L;  // 45,000đ/giờ (18h-24h)
    private static final int PHUT_MIEN_PHI = 15;
    
    @Override
    public PhieuDatPhong taoPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
        return phieuDatPhongRepository.save(phieuDatPhong);
    }
    
    @Override
    public List<Phong> traCuuPhongTrong(int soNguoi, LocalDateTime tuNgay, LocalDateTime denNgay) {
        // Tra cứu phòng trống theo số người và thời gian
        return phongRepository.findAll().stream()
                .filter(p -> {
                    Optional<LoaiPhong> loaiPhong = loaiPhongRepository.findById(p.getMaLoai());
                    return loaiPhong.isPresent() && loaiPhong.get().getSucChua() >= soNguoi && "Trống".equals(p.getTrangThai());
                })
                .toList();
    }
    
    @Override
    public Long tinhChiPhiDuKien(int soGio, LocalDateTime thoiGianBatDau) {
        long chiPhi = 0;
        int gioThuRa = thoiGianBatDau.getHour();
        
        // Tính toán dựa trên khung giờ ban ngày/đêm
        if (gioThuRa >= 8 && gioThuRa < 18) {
            chiPhi = soGio * GIA_NGAY;
        } else {
            chiPhi = soGio * GIA_DEM;
        }
        
        return chiPhi;
    }
    
    @Override
    public Optional<PhieuDatPhong> xemChiTiet(Integer maPhieu) {
        return phieuDatPhongRepository.findById(maPhieu);
    }
    
    @Override
    public PhieuDatPhong capNhatDatPhong(PhieuDatPhong phieuDatPhong) {
        return phieuDatPhongRepository.save(phieuDatPhong);
    }
    
    @Override
    public void huydatPhong(Integer maPhieu, String lyDo) {
        Optional<PhieuDatPhong> phieu = phieuDatPhongRepository.findById(maPhieu);
        if (phieu.isPresent()) {
            phieu.get().setTrangThai("Hủy");
            phieuDatPhongRepository.save(phieu.get());
        }
    }
    
    @Override
    public List<PhieuDatPhong> danhSachTheoDatPhong(String trangThai) {
        return phieuDatPhongRepository.findAll().stream()
                .filter(p -> p.getTrangThai().equals(trangThai))
                .toList();
    }
    
    @Override
    public void guiXacNhan(Integer maPhieu) {
        // TODO: Tích hợp SMS/Email service
    }
}
