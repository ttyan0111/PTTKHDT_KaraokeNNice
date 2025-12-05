package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Đặt Tiệc
 */
@Entity
@Table(name = "dat_tiec")
public class DatTiec {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;
    
    @Column(name = "ten_tiec")
    private String tenTiec;
    
    @Column(name = "ngay_to_chuc")
    private LocalDateTime ngayToChuc;
    
    @Column(name = "so_khach")
    private Integer soKhach;
    
    @Column(name = "dac_biet")
    private String dacBiet;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public DatTiec() {}

    public DatTiec(KhachHang khachHang, String tenTiec, LocalDateTime ngayToChuc, Integer soKhach) {
        this.khachHang = khachHang;
        this.tenTiec = tenTiec;
        this.ngayToChuc = ngayToChuc;
        this.soKhach = soKhach;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getTenTiec() {
        return tenTiec;
    }

    public void setTenTiec(String tenTiec) {
        this.tenTiec = tenTiec;
    }

    public LocalDateTime getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(LocalDateTime ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public Integer getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(Integer soKhach) {
        this.soKhach = soKhach;
    }

    public String getDacBiet() {
        return dacBiet;
    }

    public void setDacBiet(String dacBiet) {
        this.dacBiet = dacBiet;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
