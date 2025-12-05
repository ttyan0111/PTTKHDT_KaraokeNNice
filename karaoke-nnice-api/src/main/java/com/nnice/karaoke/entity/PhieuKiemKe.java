package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Kiểm Kê
 */
@Entity
@Table(name = "PhieuKiemKe")
public class PhieuKiemKe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKiemKe")
    private Integer maKiemKe;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "NgayKiem")
    private LocalDateTime ngayKiem;
    
    @Column(name = "KyKiem", length = 50)
    private String kyKiem;

    // Constructors
    public PhieuKiemKe() {}

    public PhieuKiemKe(Integer maNV, String kyKiem) {
        this.maNV = maNV;
        this.kyKiem = kyKiem;
        this.ngayKiem = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getMaKiemKe() {
        return maKiemKe;
    }

    public void setMaKiemKe(Integer maKiemKe) {
        this.maKiemKe = maKiemKe;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public LocalDateTime getNgayKiem() {
        return ngayKiem;
    }

    public void setNgayKiem(LocalDateTime ngayKiem) {
        this.ngayKiem = ngayKiem;
    }

    public String getKyKiem() {
        return kyKiem;
    }

    public void setKyKiem(String kyKiem) {
        this.kyKiem = kyKiem;
    }

    @Override
    public String toString() {
        return "PhieuKiemKe{" +
                "maKiemKe=" + maKiemKe +
                ", maNV=" + maNV +
                '}';
    }
}
