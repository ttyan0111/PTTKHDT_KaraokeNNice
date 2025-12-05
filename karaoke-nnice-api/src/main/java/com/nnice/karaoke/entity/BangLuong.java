package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity đại diện cho Bảng Lương
 */
@Entity
@Table(name = "BangLuong")
public class BangLuong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLuong")
    private Integer maLuong;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "Thang")
    private Integer thang;
    
    @Column(name = "Nam")
    private Integer nam;
    
    @Column(name = "TongLuongNhan")
    private BigDecimal tongLuongNhan;
    
    @Column(name = "ChiTietCacKhoan", columnDefinition = "TEXT")
    private String chiTietCacKhoan;

    // Constructors
    public BangLuong() {}

    public BangLuong(Integer maNV, Integer thang, Integer nam) {
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.tongLuongNhan = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Integer getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(Integer maLuong) {
        this.maLuong = maLuong;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getThang() {
        return thang;
    }

    public void setThang(Integer thang) {
        this.thang = thang;
    }

    public Integer getNam() {
        return nam;
    }

    public void setNam(Integer nam) {
        this.nam = nam;
    }

    public BigDecimal getTongLuongNhan() {
        return tongLuongNhan;
    }

    public void setTongLuongNhan(BigDecimal tongLuongNhan) {
        this.tongLuongNhan = tongLuongNhan;
    }

    public String getChiTietCacKhoan() {
        return chiTietCacKhoan;
    }

    public void setChiTietCacKhoan(String chiTietCacKhoan) {
        this.chiTietCacKhoan = chiTietCacKhoan;
    }

    @Override
    public String toString() {
        return "BangLuong{" +
                "maLuong=" + maLuong +
                ", maNV=" + maNV +
                ", thang=" + thang +
                ", nam=" + nam +
                '}';
    }
}
