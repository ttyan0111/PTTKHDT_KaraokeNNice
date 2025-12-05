package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Nhập
 */
@Entity
@Table(name = "PhieuNhap")
public class PhieuNhap {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;
    
    @Column(name = "MaNCC")
    private Integer maNCC;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "NgayNhap")
    private LocalDateTime ngayNhap;
    
    @Column(name = "TongTienNhap")
    private BigDecimal tongTienNhap;
    
    @Column(name = "NguoiGiaoHang", length = 100)
    private String nguoiGiaoHang;

    // Constructors
    public PhieuNhap() {}

    public PhieuNhap(Integer maNCC, Integer maNV, String nguoiGiaoHang) {
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.nguoiGiaoHang = nguoiGiaoHang;
        this.ngayNhap = LocalDateTime.now();
        this.tongTienNhap = BigDecimal.ZERO;
    }

    // Getters and Setters
    public Integer getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(Integer maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Integer getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public BigDecimal getTongTienNhap() {
        return tongTienNhap;
    }

    public void setTongTienNhap(BigDecimal tongTienNhap) {
        this.tongTienNhap = tongTienNhap;
    }

    public String getNguoiGiaoHang() {
        return nguoiGiaoHang;
    }

    public void setNguoiGiaoHang(String nguoiGiaoHang) {
        this.nguoiGiaoHang = nguoiGiaoHang;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" +
                "maPhieuNhap=" + maPhieuNhap +
                ", maNCC=" + maNCC +
                ", maNV=" + maNV +
                '}';
    }
}
