package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PhieuNhap")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuNhap {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNCC", nullable = false)
    private NhaCungCap nhaCungCap;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;
    
    @Column(name = "NgayNhap")
    private LocalDateTime ngayNhap;
    
    @Column(name = "TongTienNhap")
    private java.math.BigDecimal tongTienNhap;
    
    @Column(name = "NguoiGiaoHang", length = 100)
    private String nguoiGiaoHang;
}
