package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response cho Đặt Tiệc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatTiecResponse {
    
    private Integer maDonDatTiec;
    
    private Integer maKH;
    
    private String tenKH;
    
    private Integer maGoi;
    
    private String tenGoi;
    
    private LocalDateTime ngayToChuc;
    
    private Integer soLuongNguoi;
    
    private BigDecimal tongTien;
    
    private BigDecimal tienCoc;
    
    private String trangThai;
}
