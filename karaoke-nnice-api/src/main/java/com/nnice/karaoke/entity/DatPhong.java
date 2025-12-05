package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Đặt Phòng
 */
@Entity
@Table(name = "dat_phong")
public class DatPhong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;
    
    @ManyToOne
    @JoinColumn(name = "phong_id")
    private Phong phong;
    
    @Column(name = "thoi_gian_vao")
    private LocalDateTime thoiGianVao;
    
    @Column(name = "thoi_gian_ra_du_kien")
    private LocalDateTime thoiGianRaDuKien;
    
    @Column(name = "thoi_gian_ra_thuc_te")
    private LocalDateTime thoiGianRaThucTe;
    
    @Column(name = "tong_tien")
    private Double tongTien;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public DatPhong() {}

    public DatPhong(KhachHang khachHang, Phong phong, LocalDateTime thoiGianVao, LocalDateTime thoiGianRaDuKien) {
        this.khachHang = khachHang;
        this.phong = phong;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRaDuKien = thoiGianRaDuKien;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public LocalDateTime getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(LocalDateTime thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public LocalDateTime getThoiGianRaDuKien() {
        return thoiGianRaDuKien;
    }

    public void setThoiGianRaDuKien(LocalDateTime thoiGianRaDuKien) {
        this.thoiGianRaDuKien = thoiGianRaDuKien;
    }

    public LocalDateTime getThoiGianRaThucTe() {
        return thoiGianRaThucTe;
    }

    public void setThoiGianRaThucTe(LocalDateTime thoiGianRaThucTe) {
        this.thoiGianRaThucTe = thoiGianRaThucTe;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
