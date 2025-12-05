package com.nnice.karaoke.dto.response;

/**
 * DTO Response cho Phòng
 */
public class PhongResponse {
    
    private Long id;
    private String maPhong;
    private String tenPhong;
    private String trangThai;
    private Integer sucChua;
    private Double giaGio;
    private Long coSoId;

    // Constructors
    public PhongResponse() {}

    public PhongResponse(Long id, String maPhong, String tenPhong, String trangThai, Integer sucChua, Double giaGio) {
        this.id = id;
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.trangThai = trangThai;
        this.sucChua = sucChua;
        this.giaGio = giaGio;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getSucChua() {
        return sucChua;
    }

    public void setSucChua(Integer sucChua) {
        this.sucChua = sucChua;
    }

    public Double getGiaGio() {
        return giaGio;
    }

    public void setGiaGio(Double giaGio) {
        this.giaGio = giaGio;
    }

    public Long getCoSoId() {
        return coSoId;
    }

    public void setCoSoId(Long coSoId) {
        this.coSoId = coSoId;
    }
}
