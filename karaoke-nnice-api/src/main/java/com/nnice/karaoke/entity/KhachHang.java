package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Khách Hàng
 */
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKH")
    private Integer maKH;
    
    @Column(name = "TenKH", nullable = false, length = 100)
    private String tenKH;
    
    @Column(name = "SDT", unique = true, length = 15)
    private String sdt;
    
    @Column(name = "Email", length = 100)
    private String email;
    
    @Column(name = "LoaiKhach", length = 50)
    private String loaiKhach;

    // Constructors
    public KhachHang() {}

    public KhachHang(String tenKH, String sdt, String email, String loaiKhach) {
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.loaiKhach = loaiKhach;
    }

    // Getters and Setters
    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH=" + maKH +
                ", tenKH='" + tenKH + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                '}';
    }
}
