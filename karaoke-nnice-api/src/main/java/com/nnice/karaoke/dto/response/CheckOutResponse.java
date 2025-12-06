package com.nnice.karaoke.dto.response;

import lombok.*;
import java.time.LocalDateTime;

/**
 * DTO Response cho Check-Out
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckOutResponse {
    
    private Integer maPhieuSuDung;
    
    private Integer maPhong;
    
    private String tenPhong;
    
    private LocalDateTime gioBatDau;
    
    private LocalDateTime gioKetThuc;
    
    private Float tongThoiGian;
    
    private String trangThai;
}
