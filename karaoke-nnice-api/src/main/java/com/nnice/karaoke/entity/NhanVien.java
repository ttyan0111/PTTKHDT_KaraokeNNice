package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Nhân Viên
 */
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "HoTen", length = 100)
    private String hoTen;
    
    @Column(name = "ChucVu", length = 50)
    private String chucVu;
    
    @Column(name = "HeSoLuong")
    private Float heSoLuong;
    
    @Column(name = "TyLeThuongDoanhThu")
    private Float tyLeThuongDoanhThu;
    
    @Column(name = "MaCS")
    private Integer maCS;

    // Constructors
    public NhanVien() {}

    public NhanVien(String hoTen, String chucVu, Float heSoLuong, Float tyLeThuongDoanhThu, Integer maCS) {
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.heSoLuong = heSoLuong;
        this.tyLeThuongDoanhThu = tyLeThuongDoanhThu;
        this.maCS = maCS;
    }

    // Getters and Setters
    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(Float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public Float getTyLeThuongDoanhThu() {
        return tyLeThuongDoanhThu;
    }

    public void setTyLeThuongDoanhThu(Float tyLeThuongDoanhThu) {
        this.tyLeThuongDoanhThu = tyLeThuongDoanhThu;
    }

    public Integer getMaCS() {
        return maCS;
    }

    public void setMaCS(Integer maCS) {
        this.maCS = maCS;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", hoTen='" + hoTen + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", heSoLuong=" + heSoLuong +
                ", tyLeThuongDoanhThu=" + tyLeThuongDoanhThu +
                ", maCS=" + maCS +
                '}';
    }
}
