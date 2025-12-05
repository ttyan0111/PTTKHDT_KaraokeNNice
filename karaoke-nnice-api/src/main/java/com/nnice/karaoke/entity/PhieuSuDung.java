package com.nnice.karaoke.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Sử Dụng
 */
@Entity
@Table(name = "phieu_su_dung")
public class PhieuSuDung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "dat_phong_id")
    private DatPhong datPhong;
    
    @Column(name = "thoi_gian_tao")
    private LocalDateTime thoiGianTao;
    
    @Column(name = "thoi_gian_ket_thuc")
    private LocalDateTime thoiGianKetThuc;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public PhieuSuDung() {}

    public PhieuSuDung(DatPhong datPhong, LocalDateTime thoiGianTao) {
        this.datPhong = datPhong;
        this.thoiGianTao = thoiGianTao;
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

    public LocalDateTime getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDateTime thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
