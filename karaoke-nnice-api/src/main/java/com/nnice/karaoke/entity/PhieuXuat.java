package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Xuất
 */
@Entity
@Table(name = "phieu_xuat")
public class PhieuXuat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ma_phieu_xuat", unique = true)
    private String maPhieuXuat;
    
    @ManyToOne
    @JoinColumn(name = "mat_hang_id")
    private MatHang matHang;
    
    @Column(name = "so_luong_xuat")
    private Integer soLuongXuat;
    
    @Column(name = "ngay_xuat")
    private LocalDateTime ngayXuat;
    
    @Column(name = "trang_thai")
    private String trangThai;

    // Constructors
    public PhieuXuat() {}

    public PhieuXuat(String maPhieuXuat, MatHang matHang, Integer soLuongXuat) {
        this.maPhieuXuat = maPhieuXuat;
        this.matHang = matHang;
        this.soLuongXuat = soLuongXuat;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public Integer getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(Integer soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public LocalDateTime getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDateTime ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
