package com.nnice.karaoke.dto.request;

/**
 * DTO Request cho Order (Đơn Hàng)
 */
public class OrderRequest {
    
    private Long datPhongId;
    private Long matHangId;
    private Integer soLuong;
    private Double giaBan;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(Long datPhongId, Long matHangId, Integer soLuong, Double giaBan) {
        this.datPhongId = datPhongId;
        this.matHangId = matHangId;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    // Getters and Setters
    public Long getDatPhongId() {
        return datPhongId;
    }

    public void setDatPhongId(Long datPhongId) {
        this.datPhongId = datPhongId;
    }

    public Long getMatHangId() {
        return matHangId;
    }

    public void setMatHangId(Long matHangId) {
        this.matHangId = matHangId;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }
}
