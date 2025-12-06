package com.nnice.karaoke.dto.response;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO Response cho thông tin phòng trống
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhongTrongResponse {
    
    private Integer maPhong;
    private String tenPhong;
    private String trangThai;
    
    // Thông tin loại phòng
    private Integer maLoaiPhong;
    private String tenLoaiPhong;
    private Integer sucChua;
    private BigDecimal giaTheoGio;
    
    // Thông tin cơ sở
    private Integer maCoSo;
    private String tenCoSo;
    private String diaChiCoSo;
    
    // Chi phí dự kiến
    private BigDecimal chiPhiDuKien;
    private Float soGioDuKien;
    
    // Mô tả thêm
    private String moTa;
}
