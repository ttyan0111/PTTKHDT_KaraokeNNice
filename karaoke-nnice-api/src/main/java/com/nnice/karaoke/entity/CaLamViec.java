package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

/**
 * Entity đại diện cho Ca Làm Việc
 */
@Entity
@Table(name = "CaLamViec")
public class CaLamViec {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCa")
    private Integer maCa;
    
    @Column(name = "TenCa", length = 50)
    private String tenCa;
    
    @Column(name = "GioBatDau")
    private LocalTime gioBatDau;
    
    @Column(name = "GioKetThuc")
    private LocalTime gioKetThuc;

    // Constructors
    public CaLamViec() {}

    public CaLamViec(String tenCa, LocalTime gioBatDau, LocalTime gioKetThuc) {
        this.tenCa = tenCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    // Getters and Setters
    public Integer getMaCa() {
        return maCa;
    }

    public void setMaCa(Integer maCa) {
        this.maCa = maCa;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    @Override
    public String toString() {
        return "CaLamViec{" +
                "maCa=" + maCa +
                ", tenCa='" + tenCa + '\'' +
                ", gioBatDau=" + gioBatDau +
                ", gioKetThuc=" + gioKetThuc +
                '}';
    }
}
