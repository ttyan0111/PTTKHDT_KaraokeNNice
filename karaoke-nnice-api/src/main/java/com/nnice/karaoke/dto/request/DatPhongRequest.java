package com.nnice.karaoke.dto.request;

import java.time.LocalDateTime;

/**
 * DTO Request cho Đặt Phòng
 */
public class DatPhongRequest {
    
    private Long khachHangId;
    private Long phongId;
    private LocalDateTime thoiGianVao;
    private LocalDateTime thoiGianRaDuKien;

    // Constructors
    public DatPhongRequest() {}

    public DatPhongRequest(Long khachHangId, Long phongId, LocalDateTime thoiGianVao, LocalDateTime thoiGianRaDuKien) {
        this.khachHangId = khachHangId;
        this.phongId = phongId;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRaDuKien = thoiGianRaDuKien;
    }

    // Getters and Setters
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
}
