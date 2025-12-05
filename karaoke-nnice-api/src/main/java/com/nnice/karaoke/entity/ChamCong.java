package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Chấm Công
 */
@Entity
@Table(name = "cham_cong")
public class ChamCong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "nhan_vien_id")
    private NhanVien nhanVien;
    
    @ManyToOne
    @JoinColumn(name = "ca_lam_viec_id")
    private CaLamViec caLamViec;
    
    @Column(name = "ngay_cham_cong")
    private LocalDateTime ngayChamCong;
    
    @Column(name = "gio_vao")
    private LocalDateTime gioVao;
    
    @Column(name = "gio_ra")
    private LocalDateTime gioRa;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public ChamCong() {}

    public ChamCong(NhanVien nhanVien, CaLamViec caLamViec, LocalDateTime ngayChamCong) {
        this.nhanVien = nhanVien;
        this.caLamViec = caLamViec;
        this.ngayChamCong = ngayChamCong;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public LocalDateTime getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(LocalDateTime ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public LocalDateTime getGioVao() {
        return gioVao;
    }

    public void setGioVao(LocalDateTime gioVao) {
        this.gioVao = gioVao;
    }

    public LocalDateTime getGioRa() {
        return gioRa;
    }

    public void setGioRa(LocalDateTime gioRa) {
        this.gioRa = gioRa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
