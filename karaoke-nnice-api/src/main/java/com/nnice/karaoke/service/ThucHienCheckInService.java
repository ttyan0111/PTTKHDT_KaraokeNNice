package com.nnice.karaoke.service;

import com.nnice.karaoke.entity.PhieuSuDung;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ThucHienCheckInService {
    // Tra cứu đơn đặt phòng để check-in
    Optional<PhieuSuDung> traCuuPhieuDatPhong(String maDat);
    
    // Xác nhận thông tin khách (CMND/CCCD, số người)
    void xacNhanThongTinKhach(Integer maPhieu, String soCMND, int soNguoiThuc);
    
    // Check-in: ghi nhận thời gian vào
    PhieuSuDung thucHienCheckIn(Integer maPhieu, LocalDateTime thoiGianVao);
    
    // Check-out: ghi nhận thời gian ra
    PhieuSuDung thucHienCheckOut(Integer maPhieu, LocalDateTime thoiGianRa);
    
    // Tính tiền theo thời gian thực tế
    Long tinhTienThucTe(Integer maPhieu, LocalDateTime thoiGianRa);
    
    // Xử lý khách vãng lai (không đặt trước)
    PhieuSuDung xuLyKhachVangLai(Integer maPhong, int soNguoi, LocalDateTime thoiGianVao);
    
    // Kiểm tra phòng còn trống
    boolean kiemTraPhongTrong(Integer maPhong);
}
