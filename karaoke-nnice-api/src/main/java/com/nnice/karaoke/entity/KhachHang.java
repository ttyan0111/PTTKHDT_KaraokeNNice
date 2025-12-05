package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Khách Hàng
 */
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ten_khach_hang", nullable = false)
    private String tenKhachHang;
    
    @Column(name = "so_dien_thoai", unique = true)
    private String soDienThoai;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "dia_chi")
    private String diaChi;
    
    @Column(name = "so_cmnd")
    private String soCMND;

    // Constructors
    public KhachHang() {}

    public KhachHang(String tenKhachHang, String soDienThoai, String email, String diaChi, String soCMND) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.soCMND = soCMND;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
}
