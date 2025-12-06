package com.nnice.karaoke.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * DTO Request cho Check-in khách hàng
 * Use Case: ThucHienCheckIn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInRequest {
    
    // Tìm kiếm đặt phòng bằng mã đặt phòng hoặc SĐT
    private Integer maPhieuDat;
    
    @Pattern(regexp = "^(\\+84|0)[0-9]{9}$", message = "Số điện thoại không hợp lệ")
    private String soDienThoai;
    
    // Xác nhận thông tin khách
    @Size(max = 20, message = "Số CMND/CCCD không quá 20 ký tự")
    private String cmndCccd;
    
    @NotNull(message = "Số người thực tế không được để trống")
    @Min(value = 1, message = "Số người phải ít nhất là 1")
    private Integer soNguoiThucTe;
    
    // Mã nhân viên tiếp tân thực hiện check-in
    @NotNull(message = "Mã nhân viên không được để trống")
    private Integer maNhanVien;
    
    // Ghi chú
    @Size(max = 500, message = "Ghi chú không quá 500 ký tự")
    private String ghiChu;
}
