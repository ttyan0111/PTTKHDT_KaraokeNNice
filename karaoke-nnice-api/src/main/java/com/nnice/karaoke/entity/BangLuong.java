package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BangLuong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BangLuong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLuong")
    private Integer maLuong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;
    
    @Column(name = "Thang")
    private Integer thang;
    
    @Column(name = "Nam")
    private Integer nam;
    
    @Column(name = "TongLuongNhan")
    private java.math.BigDecimal tongLuongNhan;
    
    @Column(name = "ChiTietCacKhoan", columnDefinition = "TEXT")
    private String chiTietCacKhoan;
}
