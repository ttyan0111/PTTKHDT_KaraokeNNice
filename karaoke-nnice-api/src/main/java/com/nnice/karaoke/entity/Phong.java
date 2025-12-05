package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Phòng
 */
@Entity
@Table(name = "Phong")
public class Phong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhong")
    private Integer maPhong;
    
    @Column(name = "TenPhong", length = 50)
    private String tenPhong;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
    
    @Column(name = "MaCS")
    private Integer maCS;
    
    @Column(name = "MaLoai")
    private Integer maLoai;

    // Constructors
    public Phong() {}

    public Phong(String tenPhong, String trangThai, Integer maCS, Integer maLoai) {
        this.tenPhong = tenPhong;
        this.trangThai = trangThai;
        this.maCS = maCS;
        this.maLoai = maLoai;
    }

    // Getters and Setters
    public Integer getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(Integer maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getMaCS() {
        return maCS;
    }

    public void setMaCS(Integer maCS) {
        this.maCS = maCS;
    }

    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "Phong{" +
                "maPhong=" + maPhong +
                ", tenPhong='" + tenPhong + '\'' +
                ", trangThai='" + trangThai + '\'' +
                ", maCS=" + maCS +
                ", maLoai=" + maLoai +
                '}';
    }
}
