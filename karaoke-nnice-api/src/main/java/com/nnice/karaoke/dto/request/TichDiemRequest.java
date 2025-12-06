package com.nnice.karaoke.dto.request;

import lombok.*;

/**
 * DTO Request cho Tích Điểm Thành Viên
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TichDiemRequest {
    
    private Integer maThanhVien;
    
    private Long tongTien;
}
