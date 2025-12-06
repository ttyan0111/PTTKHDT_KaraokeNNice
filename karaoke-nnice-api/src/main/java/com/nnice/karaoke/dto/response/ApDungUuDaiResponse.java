package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;

/**
 * DTO Response cho Áp Dụng Ưu Đãi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApDungUuDaiResponse {
    
    private Integer maCauHinh;
    
    private Integer maLoai;
    
    private String khungGio;
    
    private String loaiNgay;
    
    private BigDecimal donGia;
    
    private Boolean conHan;
    
    private Boolean daSuDung;
    
    private BigDecimal tienGiam;
}
