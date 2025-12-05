package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity đại diện cho Cấu Hình Giá
 */
@Entity
@Table(name = "CauHinhGia")
public class CauHinhGia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCauHinh")
    private Integer maCauHinh;
    
    @Column(name = "MaLoai")
    private Integer maLoai;
    
    @Column(name = "KhungGio", length = 50)
    private String khungGio;
    
    @Column(name = "LoaiNgay", length = 50)
    private String loaiNgay;
    
    @Column(name = "DonGia")
    private BigDecimal donGia;

    // Constructors
    public CauHinhGia() {}

    public CauHinhGia(Integer maLoai, String khungGio, String loaiNgay, BigDecimal donGia) {
        this.maLoai = maLoai;
        this.khungGio = khungGio;
        this.loaiNgay = loaiNgay;
        this.donGia = donGia;
    }

    // Getters and Setters
    public Integer getMaCauHinh() {
        return maCauHinh;
    }

    public void setMaCauHinh(Integer maCauHinh) {
        this.maCauHinh = maCauHinh;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getKhungGio() {
        return khungGio;
    }

    public void setKhungGio(String khungGio) {
        this.khungGio = khungGio;
    }

    public String getLoaiNgay() {
        return loaiNgay;
    }

    public void setLoaiNgay(String loaiNgay) {
        this.loaiNgay = loaiNgay;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "CauHinhGia{" +
                "maCauHinh=" + maCauHinh +
                ", maLoai=" + maLoai +
                ", khungGio='" + khungGio + '\'' +
                ", loaiNgay='" + loaiNgay + '\'' +
                ", donGia=" + donGia +
                '}';
    }
}
