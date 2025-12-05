package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Cơ Sở Karaoke
 */
@Entity
@Table(name = "co_so")
public class CoSo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ten_co_so", nullable = false)
    private String tenCoSo;
    
    @Column(name = "dia_chi")
    private String diaChi;
    
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "tong_phong")
    private Integer tongPhong;

    // Constructors
    public CoSo() {}

    public CoSo(String tenCoSo, String diaChi, String soDienThoai, String email, Integer tongPhong) {
        this.tenCoSo = tenCoSo;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.tongPhong = tongPhong;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenCoSo() {
        return tenCoSo;
    }

    public void setTenCoSo(String tenCoSo) {
        this.tenCoSo = tenCoSo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public Integer getTongPhong() {
        return tongPhong;
    }

    public void setTongPhong(Integer tongPhong) {
        this.tongPhong = tongPhong;
    }
}
