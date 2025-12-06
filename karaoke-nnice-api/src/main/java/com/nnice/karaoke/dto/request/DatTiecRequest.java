package com.nnice.karaoke.dto.request;

import lombok.*;
import java.time.LocalDateTime;

/**
 * DTO Request cho Đặt Tiệc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatTiecRequest {
    
    private Integer maKH;
    
    private Integer maGoi;
    
    private LocalDateTime ngayToChuc;
    
    private Integer soLuongNguoi;
}
