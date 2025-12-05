package com.nnice.karaoke.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Ca Làm Việc
 */
@Entity
@Table(name = "ca_lam_viec")
public class CaLamViec {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ten_ca")
    private String tenCa;
    
    @Column(name = "gio_bat_dau")
    private String gioBatDau;
    
    @Column(name = "gio_ket_thuc")
    private String gioKetThuc;

    // Constructors
    public CaLamViec() {}

    public CaLamViec(String tenCa, String gioBatDau, String gioKetThuc) {
        this.tenCa = tenCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }
}
