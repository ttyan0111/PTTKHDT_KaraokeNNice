package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity đại diện cho Mặt Hàng
 */
@Entity
@Table(name = "MatHang")
public class MatHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHang")
    private Integer maHang;
    
    @Column(name = "TenHang", length = 100)
    private String tenHang;
    
    @Column(name = "LoaiHang", length = 50)
    private String loaiHang;
    
    @Column(name = "SoLuongTon")
    private Integer soLuongTon = 0;
    
    @Column(name = "DonViTinh", length = 20)
    private String donViTinh;
    
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    
    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    // Constructors
    public MatHang() {}

    public MatHang(String tenHang, String loaiHang, String donViTinh, BigDecimal giaNhap, BigDecimal giaBan) {
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTon = 0;
    }

    // Getters and Setters
    public Integer getMaHang() {
        return maHang;
    }

    public void setMaHang(Integer maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "MatHang{" +
                "maHang=" + maHang +
                ", tenHang='" + tenHang + '\'' +
                ", loaiHang='" + loaiHang + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", donViTinh='" + donViTinh + '\'' +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                '}';
    }
}
