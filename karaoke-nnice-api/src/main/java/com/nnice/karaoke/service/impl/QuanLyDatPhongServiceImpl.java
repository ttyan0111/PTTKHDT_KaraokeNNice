package com.nnice.karaoke.service.impl;

import com.nnice.karaoke.dto.request.DatPhongRequest;
import com.nnice.karaoke.dto.response.DatPhongResponse;
import com.nnice.karaoke.dto.response.PhongKhaDungResponse;
import com.nnice.karaoke.entity.*;
import com.nnice.karaoke.exception.BusinessException;
import com.nnice.karaoke.exception.ResourceNotFoundException;
import com.nnice.karaoke.repository.*;
import com.nnice.karaoke.service.QuanLyDatPhongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class QuanLyDatPhongServiceImpl implements QuanLyDatPhongService {
    
    private final PhieuDatPhongRepository phieuDatPhongRepository;
    private final PhongRepository phongRepository;
    private final KhachHangRepository khachHangRepository;
    private final CauHinhGiaRepository cauHinhGiaRepository;
    private final DoiTacRepository doiTacRepository;
    private final PhieuSuDungRepository phieuSuDungRepository;
    
    @Override
    public DatPhongResponse taoPhieuDatPhong(DatPhongRequest request) {
        log.info("Tạo phiếu đặt phòng cho khách: {}", request.getTenKH());
        
        // Kiểm tra/tạo khách hàng
        KhachHang khachHang = khachHangRepository.findBySdt(request.getSdt())
                .orElseGet(() -> {
                    KhachHang kh = KhachHang.builder()
                            .tenKH(request.getTenKH())
                            .sdt(request.getSdt())
                            .email(request.getEmail())
                            .build();
                    return khachHangRepository.save(kh);
                });
        
        // Kiểm tra phòng
        Phong phong = phongRepository.findById(request.getMaPhong())
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phòng ID: " + request.getMaPhong()));
        
        // Tạo phiếu đặt phòng
        PhieuDatPhong phieu = PhieuDatPhong.builder()
                .khachHang(khachHang)
                .phong(phong)
                .ngayDat(LocalDateTime.now())
                .gioDat(request.getGioDat())
                .gioKetThuc(request.getGioKetThuc())
                .soNguoi(request.getSoNguoi())
                .trangThai("Da dat")
                .ghiChu(request.getGhiChu())
                .build();
        
        if (request.getMaDoiTac() != null) {
            DoiTac doiTac = doiTacRepository.findById(request.getMaDoiTac())
                    .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy đối tác"));
            phieu.setDoiTac(doiTac);
        }
        
        PhieuDatPhong saved = phieuDatPhongRepository.save(phieu);
        
        return convertToResponse(saved);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<PhongKhaDungResponse> timPhongTrong(Integer soNguoi, LocalDateTime tuNgay, LocalDateTime denNgay) {
        log.info("Tìm phòng trống - Số người: {}, Từ: {}, Đến: {}", soNguoi, tuNgay, denNgay);
        
        // TODO: Implement logic to filter by soNguoi, tuNgay, denNgay
        List<Phong> phongTrong = phongRepository.findPhongTrong();
        
        return phongTrong.stream()
                .map(this::convertToPhongResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    public DatPhongResponse xemPhieuDatPhong(Integer maPhieu) {
        PhieuDatPhong phieu = phieuDatPhongRepository.findById(maPhieu)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu đặt phòng ID: " + maPhieu));
        
        return convertToResponse(phieu);
    }
    
    @Override
    public DatPhongResponse capNhatPhieuDatPhong(Integer maPhieu, DatPhongRequest request) {
        PhieuDatPhong phieu = phieuDatPhongRepository.findById(maPhieu)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu đặt phòng ID: " + maPhieu));
        
        // Cập nhật thông tin
        if (request.getGioDat() != null) {
            phieu.setGioDat(request.getGioDat());
        }
        if (request.getGioKetThuc() != null) {
            phieu.setGioKetThuc(request.getGioKetThuc());
        }
        if (request.getSoNguoi() != null) {
            phieu.setSoNguoi(request.getSoNguoi());
        }
        if (request.getGhiChu() != null) {
            phieu.setGhiChu(request.getGhiChu());
        }
        
        PhieuDatPhong updated = phieuDatPhongRepository.save(phieu);
        return convertToResponse(updated);
    }
    
    @Override
    public void huyPhieuDatPhong(Integer maPhieu, String lyDoHuy) {
        PhieuDatPhong phieu = phieuDatPhongRepository.findById(maPhieu)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy phiếu đặt phòng ID: " + maPhieu));
        
        if ("Da huy".equals(phieu.getTrangThai())) {
            throw new BusinessException("Phiếu đã bị hủy trước đó");
        }
        
        phieu.setTrangThai("Da huy");
        phieu.setGhiChu(phieu.getGhiChu() + " | Ly do huy: " + lyDoHuy);
        phieuDatPhongRepository.save(phieu);
    }
    
    @Override
    public List<DatPhongResponse> layDanhSachPhieuDatTheoKhach(Integer maKhach) {
        List<PhieuDatPhong> phieus = phieuDatPhongRepository.findByKhachHang_MaKH(maKhach);
        
        return phieus.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    
    // Helper methods
    private DatPhongResponse convertToResponse(PhieuDatPhong phieu) {
        return DatPhongResponse.builder()
                .maPhieuDat(phieu.getMaPhieuDat())
                .tenKH(phieu.getKhachHang().getTenKH())
                .sdt(phieu.getKhachHang().getSdt())
                .email(phieu.getKhachHang().getEmail())
                .tenPhong(phieu.getPhong().getTenPhong())
                .maPhong(phieu.getPhong().getMaPhong())
                .ngayDat(phieu.getNgayDat())
                .gioDat(phieu.getGioDat())
                .gioKetThuc(phieu.getGioKetThuc())
                .trangThai(phieu.getTrangThai())
                .ghiChu(phieu.getGhiChu())
                .build();
    }
    
    private PhongKhaDungResponse convertToPhongResponse(Phong phong) {
        String tenLoai = "";
        Integer sucChua = 0;
        String moTa = "";
        
        if (phong.getLoaiPhong() != null) {
            tenLoai = phong.getLoaiPhong().getTenLoai();
            sucChua = phong.getLoaiPhong().getSucChua();
            moTa = phong.getLoaiPhong().getMoTa();
        }
        
        return PhongKhaDungResponse.builder()
                .maPhong(phong.getMaPhong())
                .tenPhong(phong.getTenPhong())
                .tenLoai(tenLoai)
                .sucChua(sucChua)
                .moTa(moTa)
                .trangThai(phong.getTrangThai())
                .build();
    }
}
