package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Đơn Gọi Món
 */
@Entity
@Table(name = "DonGoiMon")
public class DonGoiMon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaOrder")
    private Integer maOrder;
    
    @Column(name = "MaPhieuSuDung")
    private Integer maPhieuSuDung;
    
    @Column(name = "ThoiGianGoi")
    private LocalDateTime thoiGianGoi;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    // Constructors
    public DonGoiMon() {}

    public DonGoiMon(Integer maPhieuSuDung, String trangThai) {
        this.maPhieuSuDung = maPhieuSuDung;
        this.trangThai = trangThai;
        this.thoiGianGoi = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getMaOrder() {
        return maOrder;
    }

    public void setMaOrder(Integer maOrder) {
        this.maOrder = maOrder;
    }

    public Integer getMaPhieuSuDung() {
        return maPhieuSuDung;
    }

    public void setMaPhieuSuDung(Integer maPhieuSuDung) {
        this.maPhieuSuDung = maPhieuSuDung;
    }

    public LocalDateTime getThoiGianGoi() {
        return thoiGianGoi;
    }

    public void setThoiGianGoi(LocalDateTime thoiGianGoi) {
        this.thoiGianGoi = thoiGianGoi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DonGoiMon{" +
                "maOrder=" + maOrder +
                ", maPhieuSuDung=" + maPhieuSuDung +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
