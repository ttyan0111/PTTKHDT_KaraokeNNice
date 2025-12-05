package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Loại Phòng
 */
@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLoai")
    private Integer maLoai;
    
    @Column(name = "TenLoai", length = 50)
    private String tenLoai;
    
    @Column(name = "SucChua")
    private Integer sucChua;

    // Constructors
    public LoaiPhong() {}

    public LoaiPhong(String tenLoai, Integer sucChua) {
        this.tenLoai = tenLoai;
        this.sucChua = sucChua;
    }

    // Getters and Setters
    public Integer getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Integer maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Integer getSucChua() {
        return sucChua;
    }

    public void setSucChua(Integer sucChua) {
        this.sucChua = sucChua;
    }

    @Override
    public String toString() {
        return "LoaiPhong{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                ", sucChua=" + sucChua +
                '}';
    }
}
