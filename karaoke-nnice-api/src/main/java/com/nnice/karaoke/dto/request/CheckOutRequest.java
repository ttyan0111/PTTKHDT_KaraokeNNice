package com.nnice.karaoke.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO Request cho Check-out khách hàng
 * Use Case: Kết thúc sử dụng phòng
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckOutRequest {
    
    @NotNull(message = "Mã phiếu sử dụng không được để trống")
    private Integer maPhieuSuDung;
    
    @NotNull(message = "Mã nhân viên không được để trống")
    private Integer maNhanVien;
    
    // Ghi chú
    @Size(max = 500, message = "Ghi chú không quá 500 ký tự")
    private String ghiChu;
}
