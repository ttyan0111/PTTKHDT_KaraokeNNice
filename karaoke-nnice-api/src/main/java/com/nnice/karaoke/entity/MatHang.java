package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Mặt Hàng
 */
@Entity
@Table(name = "mat_hang")
public class MatHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ten_mat_hang", nullable = false)
    private String tenMatHang;
    
    @Column(name = "ma_mat_hang", unique = true)
    private String maMatHang;
    
    @Column(name = "don_vi_tinh")
    private String donViTinh;
    
    @Column(name = "gia_ban")
    private Double giaBan;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public MatHang() {}

    public MatHang(String tenMatHang, String maMatHang, String donViTinh, Double giaBan) {
        this.tenMatHang = tenMatHang;
        this.maMatHang = maMatHang;
        this.donViTinh = donViTinh;
        this.giaBan = giaBan;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getMaMatHang() {
        return maMatHang;
    }

    public void setMaMatHang(String maMatHang) {
        this.maMatHang = maMatHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
