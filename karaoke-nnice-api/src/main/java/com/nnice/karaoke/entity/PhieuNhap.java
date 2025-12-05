package com.nnice.karaoke.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Nhập
 */
@Entity
@Table(name = "phieu_nhap")
public class PhieuNhap {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ma_phieu_nhap", unique = true)
    private String maPhieuNhap;
    
    @ManyToOne
    @JoinColumn(name = "mat_hang_id")
    private MatHang matHang;
    
    @Column(name = "so_luong_nhap")
    private Integer soLuongNhap;
    
    @Column(name = "gia_nhap")
    private Double giaNhap;
    
    @Column(name = "ngay_nhap")
    private LocalDateTime ngayNhap;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public PhieuNhap() {}

    public PhieuNhap(String maPhieuNhap, MatHang matHang, Integer soLuongNhap, Double giaNhap) {
        this.maPhieuNhap = maPhieuNhap;
        this.matHang = matHang;
        this.soLuongNhap = soLuongNhap;
        this.giaNhap = giaNhap;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public Integer getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(Integer soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public LocalDateTime getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDateTime ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
