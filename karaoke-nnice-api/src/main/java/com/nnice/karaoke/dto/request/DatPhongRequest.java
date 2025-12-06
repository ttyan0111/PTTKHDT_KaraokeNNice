package com.nnice.karaoke.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO cho yêu cầu đặt phòng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatPhongRequest {
    
    // Thông tin khách hàng
    @JsonProperty("tenKH")
    @JsonAlias({"tenKhachHang", "ten_khach_hang"})
    private String tenKH;
    
    @JsonProperty("sdt")
    @JsonAlias({"soDienThoai", "so_dien_thoai"})
    private String sdt;
    
    private String email;
    
    // Thông tin đặt phòng
    private Integer soNguoi;
    private LocalDateTime gioDat;
    private LocalDateTime gioKetThuc;
    private String ghiChu;
    
    // Thông tin phòng (optional - nếu khách đã chọn phòng cụ thể)
    private Integer maPhong;
    
    // Thông tin cơ sở
    private Integer maCoSo;
    
    // Thông tin đối tác (nếu có)
    private Integer maDoiTac;
    
    // Thông tin khách hàng hiện tại (nếu đã có)
    private Integer maKhach;
}
