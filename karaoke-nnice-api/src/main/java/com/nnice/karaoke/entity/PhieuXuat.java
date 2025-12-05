package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Xuất
 */
@Entity
@Table(name = "PhieuXuat")
public class PhieuXuat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuXuat")
    private Integer maPhieuXuat;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "NgayXuat")
    private LocalDateTime ngayXuat;
    
    @Column(name = "LyDoXuat", length = 255)
    private String lyDoXuat;

    // Constructors
    public PhieuXuat() {}

    public PhieuXuat(Integer maNV, String lyDoXuat) {
        this.maNV = maNV;
        this.lyDoXuat = lyDoXuat;
        this.ngayXuat = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(Integer maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public LocalDateTime getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDateTime ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getLyDoXuat() {
        return lyDoXuat;
    }

    public void setLyDoXuat(String lyDoXuat) {
        this.lyDoXuat = lyDoXuat;
    }

    @Override
    public String toString() {
        return "PhieuXuat{" +
                "maPhieuXuat=" + maPhieuXuat +
                ", maNV=" + maNV +
                '}';
    }
}
