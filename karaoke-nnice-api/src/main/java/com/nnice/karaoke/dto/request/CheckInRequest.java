package com.nnice.karaoke.dto.request;

import java.time.LocalDateTime;

/**
 * DTO Request cho Check-In
 */
public class CheckInRequest {
    
    private Long datPhongId;
    private LocalDateTime thoiGianVao;

    // Constructors
    public CheckInRequest() {}

    public CheckInRequest(Long datPhongId, LocalDateTime thoiGianVao) {
        this.datPhongId = datPhongId;
        this.thoiGianVao = thoiGianVao;
    }

    // Getters and Setters
    public Long getDatPhongId() {
        return datPhongId;
    }

    public void setDatPhongId(Long datPhongId) {
        this.datPhongId = datPhongId;
    }

    public LocalDateTime getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(LocalDateTime thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }
}
