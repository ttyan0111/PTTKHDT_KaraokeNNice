package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Đặt Phòng
 */
@Entity
@Table(name = "PhieuDatPhong")
public class PhieuDatPhong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuDat")
    private Integer maPhieuDat;
    
    @Column(name = "MaKH")
    private Integer maKH;
    
    @Column(name = "MaDT")
    private Integer maDT;
    
    @Column(name = "NgayDat")
    private LocalDateTime ngayDat;
    
    @Column(name = "GioDat")
    private LocalDateTime gioDat;
    
    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;
    
    @Column(name = "TienCoc")
    private BigDecimal tienCoc = BigDecimal.ZERO;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    // Constructors
    public PhieuDatPhong() {}

    public PhieuDatPhong(Integer maKH, LocalDateTime gioDat, LocalDateTime gioKetThuc, String trangThai) {
        this.maKH = maKH;
        this.gioDat = gioDat;
        this.gioKetThuc = gioKetThuc;
        this.trangThai = trangThai;
        this.ngayDat = LocalDateTime.now();
        this.tienCoc = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Integer getMaPhieuDat() {
        return maPhieuDat;
    }

    public void setMaPhieuDat(Integer maPhieuDat) {
        this.maPhieuDat = maPhieuDat;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaDT() {
        return maDT;
    }

    public void setMaDT(Integer maDT) {
        this.maDT = maDT;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalDateTime getGioDat() {
        return gioDat;
    }

    public void setGioDat(LocalDateTime gioDat) {
        this.gioDat = gioDat;
    }

    public LocalDateTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalDateTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public BigDecimal getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(BigDecimal tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "PhieuDatPhong{" +
                "maPhieuDat=" + maPhieuDat +
                ", maKH=" + maKH +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
