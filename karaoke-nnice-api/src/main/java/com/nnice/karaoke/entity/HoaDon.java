package com.nnice.karaoke.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Hóa Đơn
 */
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ma_hoa_don", unique = true)
    private String maHoaDon;
    
    @ManyToOne
    @JoinColumn(name = "dat_phong_id")
    private DatPhong datPhong;
    
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    
    @Column(name = "tong_tien")
    private Double tongTien;
    
    @Column(name = "thue")
    private Double thue;
    
    @Column(name = "tong_thanh_toan")
    private Double tongThanhToan;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public HoaDon() {}

    public HoaDon(String maHoaDon, DatPhong datPhong, Double tongTien) {
        this.maHoaDon = maHoaDon;
        this.datPhong = datPhong;
        this.tongTien = tongTien;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public DatPhong getDatPhong() {
        return datPhong;
    }

    public void setDatPhong(DatPhong datPhong) {
        this.datPhong = datPhong;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getThue() {
        return thue;
    }

    public void setThue(Double thue) {
        this.thue = thue;
    }

    public Double getTongThanhToan() {
        return tongThanhToan;
    }

    public void setTongThanhToan(Double tongThanhToan) {
        this.tongThanhToan = tongThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
