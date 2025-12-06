package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response cho Check-in
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInResponse {
    
    // Mã phiếu sử dụng
    private Integer maPhieuSuDung;
    
    // Thông tin phiếu đặt phòng
    private Integer maPhieuDat;
    
    // Thông tin khách hàng
    private String tenKhachHang;
    private String soDienThoai;
    
    // Thông tin phòng
    private Integer maPhong;
    private String tenPhong;
    private String trangThaiPhong;
    
    // Thông tin thời gian
    private LocalDateTime thoiGianCheckIn;
    private LocalDateTime thoiGianDuKienCheckOut;
    
    // Thông tin nhân viên
    private Integer maNhanVien;
    private String tenNhanVien;
    
    // Trạng thái
    private String trangThai; // "Đang sử dụng"
    
    // Thông báo
    private String thongBao;
    
    // Chìa khóa/thẻ phòng
    private String maThePhong;
}
