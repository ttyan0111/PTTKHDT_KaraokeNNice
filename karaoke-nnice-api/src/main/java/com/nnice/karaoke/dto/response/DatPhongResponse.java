package com.nnice.karaoke.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO cho phản hồi thông tin đặt phòng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatPhongResponse {
    
    private Integer maPhieuDat;
    private String maDatPhong; // Mã duy nhất để khách tra cứu
    
    // Thông tin khách hàng
    private String tenKH;
    private String sdt;
    private String email;
    
    // Thông tin phòng
    private Integer maPhong;
    private String tenPhong;
    private String loaiPhong;
    
    // Thông tin đặt phòng
    private LocalDateTime ngayDat;
    private LocalDateTime gioDat;
    private LocalDateTime gioKetThuc;
    private BigDecimal chiPhiDuKien;
    private BigDecimal tienCoc;
    private String trangThai;
    
    // Thông tin cơ sở
    private String tenCoSo;
    private String diaChiCoSo;
    
    private String ghiChu;
}
