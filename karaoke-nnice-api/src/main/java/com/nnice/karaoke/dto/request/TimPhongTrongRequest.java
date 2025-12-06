package com.nnice.karaoke.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO Request cho tìm phòng trống phù hợp
 * Use Case: QuanLyDatPhong - Bước tìm phòng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimPhongTrongRequest {
    
    @NotNull(message = "Số người không được để trống")
    @Min(value = 1, message = "Số người phải ít nhất là 1")
    private Integer soNguoi;
    
    @NotNull(message = "Thời gian bắt đầu không được để trống")
    private String thoiGianBatDau; // ISO 8601 format: 2025-12-06T14:00:00
    
    @NotNull(message = "Thời gian kết thúc không được để trống")
    private String thoiGianKetThuc;
    
    // Mã cơ sở (optional)
    private Integer maCoSo;
    
    // Mã loại phòng (optional - VIP, Standard, etc.)
    private Integer maLoaiPhong;
}
