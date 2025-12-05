package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entity đại diện cho Bảng Chấm Công
 */
@Entity
@Table(name = "BangChamCong")
public class BangChamCong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChamCong")
    private Integer maChamCong;
    
    @Column(name = "MaNV")
    private Integer maNV;
    
    @Column(name = "MaCa")
    private Integer maCa;
    
    @Column(name = "NgayLam")
    private LocalDate ngayLam;
    
    @Column(name = "GioCheckIn")
    private LocalDate gioCheckIn;
    
    @Column(name = "GioCheckOut")
    private LocalDate gioCheckOut;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;

    // Constructors
    public BangChamCong() {}

    public BangChamCong(Integer maNV, Integer maCa, LocalDate ngayLam, String trangThai) {
        this.maNV = maNV;
        this.maCa = maCa;
        this.ngayLam = ngayLam;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public Integer getMaChamCong() {
        return maChamCong;
    }

    public void setMaChamCong(Integer maChamCong) {
        this.maChamCong = maChamCong;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getMaCa() {
        return maCa;
    }

    public void setMaCa(Integer maCa) {
        this.maCa = maCa;
    }

    public LocalDate getNgayLam() {
        return ngayLam;
    }

    public void setNgayLam(LocalDate ngayLam) {
        this.ngayLam = ngayLam;
    }

    public LocalDate getGioCheckIn() {
        return gioCheckIn;
    }

    public void setGioCheckIn(LocalDate gioCheckIn) {
        this.gioCheckIn = gioCheckIn;
    }

    public LocalDate getGioCheckOut() {
        return gioCheckOut;
    }

    public void setGioCheckOut(LocalDate gioCheckOut) {
        this.gioCheckOut = gioCheckOut;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "BangChamCong{" +
                "maChamCong=" + maChamCong +
                ", maNV=" + maNV +
                ", ngayLam=" + ngayLam +
                '}';
    }
}
