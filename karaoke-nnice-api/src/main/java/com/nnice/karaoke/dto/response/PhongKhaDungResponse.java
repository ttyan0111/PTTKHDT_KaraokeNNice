package com.nnice.karaoke.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO cho thông tin phòng khả dụng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhongKhaDungResponse {
    
    private Integer maPhong;
    private String tenPhong;
    private String trangThai;
    
    // Thông tin loại phòng
    private Integer maLoai;
    private String tenLoai;
    private Integer sucChua;
    private String moTa;
    
    // Giá phòng
    private BigDecimal giaMoiGio;
    private BigDecimal giaTheoKhungGio; // Giá áp dụng cho khung giờ cụ thể
    
    // Thông tin cơ sở
    private Integer maCoSo;
    private String tenCoSo;
}
