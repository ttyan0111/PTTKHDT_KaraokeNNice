package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Hóa Đơn
 */
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHD")
    private Integer maHD;
    
    @Column(name = "MaPhieuSuDung", unique = true, nullable = false)
    private Integer maPhieuSuDung;
    
    @Column(name = "MaKH")
    private Integer maKH;
    
    @Column(name = "NgayLap")
    private LocalDateTime ngayLap;
    
    @Column(name = "ThueVAT")
    private BigDecimal thueVAT;
    
    @Column(name = "GiamGia")
    private BigDecimal giamGia;
    
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    
    @Column(name = "HinhThucThanhToan", length = 50)
    private String hinhThucThanhToan;

    // Constructors
    public HoaDon() {}

    public HoaDon(Integer maPhieuSuDung, Integer maKH, BigDecimal tongTien, String hinhThucThanhToan) {
        this.maPhieuSuDung = maPhieuSuDung;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.ngayLap = LocalDateTime.now();
        this.thueVAT = BigDecimal.ZERO;
        this.giamGia = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getMaPhieuSuDung() {
        return maPhieuSuDung;
    }

    public void setMaPhieuSuDung(Integer maPhieuSuDung) {
        this.maPhieuSuDung = maPhieuSuDung;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public LocalDateTime getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }

    public BigDecimal getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(BigDecimal thueVAT) {
        this.thueVAT = thueVAT;
    }

    public BigDecimal getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(BigDecimal giamGia) {
        this.giamGia = giamGia;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHD=" + maHD +
                ", maPhieuSuDung=" + maPhieuSuDung +
                ", tongTien=" + tongTien +
                '}';
    }
}
