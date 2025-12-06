package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response cho Order Ăn/Uống
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    
    private Integer maOrder;
    
    private Integer maPhieuSuDung;
    
    private Integer maHang;
    
    private String tenHang;
    
    private Integer soLuong;
    
    private BigDecimal giaBan;
    
    private BigDecimal thanhTien;
    
    private LocalDateTime thoiGianGoi;
    
    private String trangThai;
}
