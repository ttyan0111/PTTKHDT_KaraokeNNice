package com.nnice.karaoke.service;

import com.nnice.karaoke.dto.request.CheckInRequest;
import com.nnice.karaoke.dto.request.CheckOutRequest;
import com.nnice.karaoke.dto.response.CheckInResponse;
import com.nnice.karaoke.dto.response.CheckOutResponse;
import java.time.LocalDateTime;

public interface ThucHienCheckInService {
    // Tra cứu đơn đặt phòng để check-in
    CheckInResponse traCuuPhieuDatPhong(String maDat);
    
    // Xác nhận thông tin khách (CMND/CCCD, số người)
    void xacNhanThongTinKhach(Integer maPhieu, String soCMND, int soNguoiThuc);
    
    // Check-in: ghi nhận thời gian vào
    CheckInResponse thucHienCheckIn(CheckInRequest request);
    
    // Check-out: ghi nhận thời gian ra
    CheckOutResponse thucHienCheckOut(CheckOutRequest request);
    
    // Tính tiền theo thời gian thực tế
    Long tinhTienThucTe(Integer maPhieu, LocalDateTime thoiGianRa);
    
    // Xử lý khách vãng lai (không đặt trước)
    CheckInResponse xuLyKhachVangLai(Integer maPhong, int soNguoi, LocalDateTime thoiGianVao);
    
    // Kiểm tra phòng còn trống
    boolean kiemTraPhongTrong(Integer maPhong);
}
