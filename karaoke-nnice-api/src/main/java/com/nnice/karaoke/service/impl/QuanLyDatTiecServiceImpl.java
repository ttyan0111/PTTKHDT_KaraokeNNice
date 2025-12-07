package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.request.DatTiecRequest;
import com.nnice.karaoke.dto.response.DatTiecResponse;
import com.nnice.karaoke.entity.DonDatTiec;
import com.nnice.karaoke.entity.KhachHang;
import com.nnice.karaoke.entity.GoiTiec;
import com.nnice.karaoke.repository.DonDatTiecRepository;
import com.nnice.karaoke.repository.KhachHangRepository;
import com.nnice.karaoke.repository.GoiTiecRepository;
import com.nnice.karaoke.service.QuanLyDatTiecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuanLyDatTiecServiceImpl implements QuanLyDatTiecService {
    
    @Autowired
    private DonDatTiecRepository donDatTiecRepository;
    
    @Autowired
    private KhachHangRepository khachHangRepository;
    
    @Autowired
    private GoiTiecRepository goiTiecRepository;
    
    private static final double TY_LE_COC = 0.20; // 20%
    
    @Override
    public DatTiecResponse taoDonDatTiec(DatTiecRequest request) {
        if (request == null || request.getMaKH() == null || request.getMaGoi() == null) {
            throw new RuntimeException("DatTiecRequest, MaKH and MaGoi cannot be null");
        }
        DonDatTiec don = new DonDatTiec();
        
        KhachHang khachHang = khachHangRepository.findById(request.getMaKH())
                .orElseThrow(() -> new RuntimeException("KhachHang not found with id: " + request.getMaKH()));
        GoiTiec goiTiec = goiTiecRepository.findById(request.getMaGoi())
                .orElseThrow(() -> new RuntimeException("GoiTiec not found with id: " + request.getMaGoi()));
        
        don.setKhachHang(khachHang);
        don.setGoiTiec(goiTiec);
        don.setNgayToChuc(request.getNgayToChuc());
        don.setSoLuongNguoi(request.getSoLuongNguoi());
        don.setTrangThai("Chờ xác nhận");
        
        DonDatTiec saved = donDatTiecRepository.save(don);
        return convertToResponse(saved);
    }
    
    @Override
    public Long tinhChiPhiTiec(Integer maTiec) {
        return 0L; // TODO: Implement
    }
    
    @Override
    public Long tinhTienDatCoc(Long tongChiPhi) {
        return (long) (tongChiPhi * TY_LE_COC);
    }
    
    @Override
    public void xuLyThanhToanCoc(Integer maTiec, Long soTien, String hinhThuc) {
        // TODO: Implement
    }
    
    @Override
    public DatTiecResponse xemChiTiet(Integer maTiec) {
        return donDatTiecRepository.findById(maTiec)
                .map(this::convertToResponse)
                .orElse(null);
    }
    
    @Override
    public DatTiecResponse capNhatDatTiec(Integer maTiec, DatTiecRequest request) {
        DonDatTiec don = donDatTiecRepository.findById(maTiec).orElse(null);
        if (don != null) {
            // Sử dụng relationship - lấy entity từ database
            KhachHang khachHang = khachHangRepository.findById(request.getMaKH()).orElse(null);
            GoiTiec goiTiec = goiTiecRepository.findById(request.getMaGoi()).orElse(null);
            
            don.setKhachHang(khachHang);
            don.setGoiTiec(goiTiec);
            don.setNgayToChuc(request.getNgayToChuc());
            don.setSoLuongNguoi(request.getSoLuongNguoi());
            DonDatTiec updated = donDatTiecRepository.save(don);
            return convertToResponse(updated);
        }
        return null;
    }
    
    @Override
    public void huyDatTiec(Integer maTiec, String lyDo) {
        donDatTiecRepository.findById(maTiec).ifPresent(don -> {
            don.setTrangThai("Hủy");
            donDatTiecRepository.save(don);
        });
    }
    
    @Override
    public List<DatTiecResponse> danhSachDatTiec(String trangThai) {
        return donDatTiecRepository.findAll().stream()
                .filter(d -> d.getTrangThai().equals(trangThai))
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    public void khoapHongTiec(Integer maTiec) {
        // TODO: Implement
    }
    
    @Override
    public void guiXacNhan(Integer maTiec) {
        // TODO: Implement SMS/Email service
    }
    
    /**
     * Convert DonDatTiec entity to DatTiecResponse DTO
     */
    private DatTiecResponse convertToResponse(DonDatTiec don) {
        return DatTiecResponse.builder()
                .maDonDatTiec(don.getMaDonDatTiec())
                .maKH(don.getKhachHang() != null ? don.getKhachHang().getMaKH() : null)
                .maGoi(don.getGoiTiec() != null ? don.getGoiTiec().getMaGoi() : null)
                .ngayToChuc(don.getNgayToChuc())
                .soLuongNguoi(don.getSoLuongNguoi())
                .tongTien(don.getTongTien())
                .tienCoc(don.getTienCoc())
                .trangThai(don.getTrangThai())
                .build();
    }
}
