package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Đặt Phòng
 */
@Entity
@Table(name = "PhieuDatPhong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuDatPhong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuDat")
    private Integer maPhieuDat;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKH")
    private KhachHang khachHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong")
    private Phong phong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaDT")
    private DoiTac doiTac;
    
    @Column(name = "NgayDat")
    private LocalDateTime ngayDat;
    
    @Column(name = "GioDat")
    private LocalDateTime gioDat;
    
    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;
    
    @Column(name = "SoNguoi")
    private Integer soNguoi;
    
    @Column(name = "TienCoc")
    private BigDecimal tienCoc;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
    
    @Column(name = "GhiChu", length = 500)
    private String ghiChu;
}
