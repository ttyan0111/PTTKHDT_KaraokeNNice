package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity đại diện cho Thẻ Thành Viên
 */
@Entity
@Table(name = "TheThanhVien")
public class TheThanhVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThe")
    private Integer maThe;
    
    @Column(name = "MaKH", nullable = false, unique = true)
    private Integer maKH;
    
    @Column(name = "HangThe", length = 50)
    private String hangThe;
    
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy = 0;
    
    @Column(name = "NgayCap")
    private LocalDate ngayCap;

    // Constructors
    public TheThanhVien() {}

    public TheThanhVien(Integer maKH, String hangThe) {
        this.maKH = maKH;
        this.hangThe = hangThe;
        this.diemTichLuy = 0;
        this.ngayCap = LocalDate.now();
    }

    // Getters and Setters
    public Integer getMaThe() {
        return maThe;
    }

    public void setMaThe(Integer maThe) {
        this.maThe = maThe;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getHangThe() {
        return hangThe;
    }

    public void setHangThe(String hangThe) {
        this.hangThe = hangThe;
    }

    public Integer getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(Integer diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    public LocalDate getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(LocalDate ngayCap) {
        this.ngayCap = ngayCap;
    }

    @Override
    public String toString() {
        return "TheThanhVien{" +
                "maThe=" + maThe +
                ", maKH=" + maKH +
                ", hangThe='" + hangThe + '\'' +
                ", diemTichLuy=" + diemTichLuy +
                ", ngayCap=" + ngayCap +
                '}';
    }
}

