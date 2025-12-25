package com.nnice.karaoke.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for occupied time slots
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OccupiedSlotResponse {

    private Integer maPhong;
    private String tenPhong;
    private LocalDateTime gioDat;
    private LocalDateTime gioKetThuc;
    private Integer maPhieuDat;
    private String tenKH;
}
