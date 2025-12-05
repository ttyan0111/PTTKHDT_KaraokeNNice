package com.nnice.karaoke.dto.response;

import java.time.LocalDateTime;

/**
 * DTO Response cho Đặt Phòng
 */
public class DatPhongResponse {
    
    private Long id;
    private Long khachHangId;
    private Long phongId;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRaDuKien;
    private LocalDateTime thoiGianRaThucTe;
    private Double tongTien;
    private String trangThai;

    // Constructors
    public DatPhongResponse() {}

    public DatPhongResponse(Long id, Long khachHangId, Long phongId, LocalDateTime thoiGianVao, String trangThai) {
        this.id = id;
        this.khachHangId = khachHangId;
        this.phongId = phongId;
        this.thoiGianVao = thoiGianVao;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(Long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public Long getPhongId() {
        return phongId;
    }

    public void setPhongId(Long phongId) {
        this.phongId = phongId;
    }

    public LocalDateTime getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(LocalDateTime thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public LocalDateTime getThoiGianRaDuKien() {
        return thoiGianRaDuKien;
    }

    public void setThoiGianRaDuKien(LocalDateTime thoiGianRaDuKien) {
        this.thoiGianRaDuKien = thoiGianRaDuKien;
    }

    public LocalDateTime getThoiGianRaThucTe() {
        return thoiGianRaThucTe;
    }

    public void setThoiGianRaThucTe(LocalDateTime thoiGianRaThucTe) {
        this.thoiGianRaThucTe = thoiGianRaThucTe;
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
