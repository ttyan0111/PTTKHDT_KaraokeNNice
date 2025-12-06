package com.nnice.karaoke.dto.request;

import lombok.*;
import java.math.BigDecimal;

/**
 * DTO Request cho Thanh Toán
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThanhToanRequest {
    
    private Integer maHoaDon;
    
    private BigDecimal soTien;
    
    private String hinhThuc; // "Tiền mặt", "Thẻ", etc
}
