package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Sử Dụng
 */
@Entity
@Table(name = "PhieuSuDung")
public class PhieuSuDung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuSuDung")
    private Integer maPhieuSuDung;
    
    @Column(name = "MaPhong")
    private Integer maPhong;
    
    @Column(name = "MaPhieuDat")
    private Integer maPhieuDat;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "GioBatDau")
    private LocalDateTime gioBatDau;
    
    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;
    
    @Column(name = "TongThoiGian")
    private Float tongThoiGian;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    // Constructors
    public PhieuSuDung() {}

    public PhieuSuDung(Integer maPhong, Integer maNV, LocalDateTime gioBatDau, String trangThai) {
        this.maPhong = maPhong;
        this.maNV = maNV;
        this.gioBatDau = gioBatDau;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public Integer getMaPhieuSuDung() {
        return maPhieuSuDung;
    }

    public void setMaPhieuSuDung(Integer maPhieuSuDung) {
        this.maPhieuSuDung = maPhieuSuDung;
    }

    public Integer getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(Integer maPhong) {
        this.maPhong = maPhong;
    }

    public Integer getMaPhieuDat() {
        return maPhieuDat;
    }

    public void setMaPhieuDat(Integer maPhieuDat) {
        this.maPhieuDat = maPhieuDat;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public LocalDateTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalDateTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalDateTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalDateTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Float getTongThoiGian() {
        return tongThoiGian;
    }

    public void setTongThoiGian(Float tongThoiGian) {
        this.tongThoiGian = tongThoiGian;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuSuDung{" +
                "maPhieuSuDung=" + maPhieuSuDung +
                ", maPhong=" + maPhong +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
