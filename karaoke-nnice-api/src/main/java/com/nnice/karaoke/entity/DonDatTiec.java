package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Đơn Đặt Tiệc
 */
@Entity
@Table(name = "DonDatTiec")
public class DonDatTiec {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDonDatTiec")
    private Integer maDonDatTiec;
    
    @Column(name = "MaKH")
    private Integer maKH;
    
    @Column(name = "MaGoi")
    private Integer maGoi;
    
    @Column(name = "NgayToChuc")
    private LocalDateTime ngayToChuc;
    
    @Column(name = "SoLuongNguoi")
    private Integer soLuongNguoi;
    
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    
    @Column(name = "TienCoc")
    private BigDecimal tienCoc;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    // Constructors
    public DonDatTiec() {}

    public DonDatTiec(Integer maKH, LocalDateTime ngayToChuc, Integer soLuongNguoi, String trangThai) {
        this.maKH = maKH;
        this.ngayToChuc = ngayToChuc;
        this.soLuongNguoi = soLuongNguoi;
        this.trangThai = trangThai;
        this.tongTien = BigDecimal.ZERO;
        this.tienCoc = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Integer getMaDonDatTiec() {
        return maDonDatTiec;
    }

    public void setMaDonDatTiec(Integer maDonDatTiec) {
        this.maDonDatTiec = maDonDatTiec;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public Integer getMaGoi() {
        return maGoi;
    }

    public void setMaGoi(Integer maGoi) {
        this.maGoi = maGoi;
    }

    public LocalDateTime getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(LocalDateTime ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public Integer getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(Integer soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
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
        return "DonDatTiec{" +
                "maDonDatTiec=" + maDonDatTiec +
                ", maKH=" + maKH +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
