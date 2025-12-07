package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

/**
 * Entity đại diện cho Hóa Đơn
 */
@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoaDon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHD")
    private Integer maHD;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhieuSuDung", unique = true, nullable = false)
    private PhieuSuDung phieuSuDung;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKH")
    private KhachHang khachHang;
    
    @Column(name = "NgayLap")
    private LocalDateTime ngayLap;
    
    @Column(name = "TienPhong")
    private BigDecimal tienPhong;
    
    @Column(name = "TienDichVu")
    private BigDecimal tienDichVu;
    
    @Column(name = "TongTienChuaThue")
    private BigDecimal tongTienChuaThue;
    
    @Column(name = "ThueVAT")
    private BigDecimal thueVAT;
    
    @Column(name = "GiamGia")
    private BigDecimal giamGia;
    
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    
    @Column(name = "TienCocDaTra")
    private BigDecimal tienCocDaTra;
    
    @Column(name = "ConPhaiTra")
    private BigDecimal conPhaiTra;
    
    @Column(name = "HinhThucThanhToan", length = 50)
    private String hinhThucThanhToan;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNVThanhToan")
    private NhanVien nhanVienThanhToan;
    
    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;
    
    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;
}
