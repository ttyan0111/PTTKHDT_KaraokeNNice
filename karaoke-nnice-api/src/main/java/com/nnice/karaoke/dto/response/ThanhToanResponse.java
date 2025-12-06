package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response cho Thanh Toán
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThanhToanResponse {
    
    private Integer maHoaDon;
    
    private Integer maPhieuSuDung;
    
    private Integer maKH;
    
    private String tenKH;
    
    private LocalDateTime ngayLap;
    
    private BigDecimal tienPhong;
    
    private BigDecimal tienAnUong;
    
    private BigDecimal thueVAT;
    
    private BigDecimal giamGia;
    
    private BigDecimal tongTien;
    
    private String hinhThucThanhToan;
    
    private String trangThai;
}
