package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Order (Đơn Hàng)
 */
@Entity
@Table(name = "order_table")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "dat_phong_id")
    private DatPhong datPhong;
    
    @Column(name = "so_hieu_don")
    private String soHieuDon;
    
    @Column(name = "tong_tien")
    private Double tongTien;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public Order() {}

    public Order(DatPhong datPhong, String soHieuDon, Double tongTien) {
        this.datPhong = datPhong;
        this.soHieuDon = soHieuDon;
        this.tongTien = tongTien;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatPhong getDatPhong() {
        return datPhong;
    }

    public void setDatPhong(DatPhong datPhong) {
        this.datPhong = datPhong;
    }

    public String getSoHieuDon() {
        return soHieuDon;
    }

    public void setSoHieuDon(String soHieuDon) {
        this.soHieuDon = soHieuDon;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
