package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Phòng Karaoke
 */
@Entity
@Table(name = "phong")
public class Phong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "ma_phong", nullable = false)
    private String maPhong;
    
    @Column(name = "ten_phong")
    private String tenPhong;
    
    @Column(name = "trang_thai")
    private String trangThai;
    
    @Column(name = "suc_chua")
    private Integer sucChua;
    
    @Column(name = "gia_gio")
    private Double giaGio;
    
    @ManyToOne
    @JoinColumn(name = "co_so_id")
    private CoSo coSo;

    // Constructors
    public Phong() {}

    public Phong(String maPhong, String tenPhong, String trangThai, Integer sucChua, Double giaGio) {
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

    public CoSo getCoSo() {
        return coSo;
    }

    public void setCoSo(CoSo coSo) {
        this.coSo = coSo;
    }
}
