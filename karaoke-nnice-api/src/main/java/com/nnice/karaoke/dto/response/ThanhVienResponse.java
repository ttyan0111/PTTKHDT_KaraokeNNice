package com.nnice.karaoke.dto.response;

import lombok.*;
import java.time.LocalDate;

/**
 * DTO Response cho Xem Thông Tin Thành Viên (Điểm & Hạng)
 * Map từ TheThanhVien entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThanhVienResponse {
    
    private Integer maThe;
    
    private Integer maKH;
    
    private String hangThe;
    
    private Integer diemTichLuy;
    
    private LocalDate ngayCap;
}
