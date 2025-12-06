package com.nnice.karaoke.dto.request;

import lombok.*;

/**
 * DTO Request cho Order Ăn/Uống
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    
    private Integer maPhieuSuDung;
    
    private Integer maHang;
    
    private Integer soLuong;
}
