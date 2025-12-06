package com.nnice.karaoke.dto.response;

import lombok.*;
import java.time.LocalDate;

/**
 * DTO Response cho Tích Điểm Thành Viên
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TichDiemResponse {
    
    private Integer maThe;
    
    private Integer maKH;
    
    private String tenKH;
    
    private String hangThe;
    
    private Integer diemTichLuy;
    
    private LocalDate ngayCap;
    
    private Integer diemTangThem;
    
    private String thongBao;
}
