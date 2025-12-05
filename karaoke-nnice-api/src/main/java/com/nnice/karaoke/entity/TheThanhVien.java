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
    private Long maThe;
    
    @Column(name = "MaKH", nullable = false)
    private Long maKH;
    
    @Column(name = "HangThe")
    private String hangThe;
    
    @Column(name = "DiemTichLuy")
    private Integer diemTichLuy = 0;
    
    @Column(name = "NgayCap")
    private LocalDate ngayCap;

    // Constructors
    public TheThanhVien() {
        this.ngayCap = LocalDate.now();
        this.diemTichLuy = 0;
    }

    public TheThanhVien(Long maKH, String hangThe) {
        this.maKH = maKH;
        this.hangThe = hangThe;
        this.ngayCap = LocalDate.now();
        this.diemTichLuy = 0;
    }

    // Getters and Setters
    public Long getMaThe() {
        return maThe;
    }

    public void setMaThe(Long maThe) {
        this.maThe = maThe;
    }

    public Long getMaKH() {
        return maKH;
    }

    public void setMaKH(Long maKH) {
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
}
