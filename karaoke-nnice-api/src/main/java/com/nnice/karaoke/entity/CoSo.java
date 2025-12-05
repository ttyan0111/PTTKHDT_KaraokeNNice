package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Cơ Sở Karaoke
 */
@Entity
@Table(name = "CoSo")
public class CoSo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCS")
    private Integer maCS;
    
    @Column(name = "TenCS", nullable = false, length = 100)
    private String tenCS;
    
    @Column(name = "DiaChi", length = 255)
    private String diaChi;
    
    @Column(name = "SDT", length = 15)
    private String sdt;

    // Constructors
    public CoSo() {}

    public CoSo(String tenCS, String diaChi, String sdt) {
        this.tenCS = tenCS;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    // Getters and Setters
    public Integer getMaCS() {
        return maCS;
    }

    public void setMaCS(Integer maCS) {
        this.maCS = maCS;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "CoSo{" +
                "maCS=" + maCS +
                ", tenCS='" + tenCS + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
