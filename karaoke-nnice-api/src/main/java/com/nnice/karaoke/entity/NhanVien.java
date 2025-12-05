package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Nhân Viên
 */
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ho_ten", nullable = false)
    private String hoTen;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    
    @Column(name = "chuc_vu")
    private String chucVu;
    
    @Column(name = "luong_co_ban")
    private Double luongCoBan;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public NhanVien() {}

    public NhanVien(String hoTen, String email, String soDienThoai, String chucVu, Double luongCoBan) {
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(Double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
