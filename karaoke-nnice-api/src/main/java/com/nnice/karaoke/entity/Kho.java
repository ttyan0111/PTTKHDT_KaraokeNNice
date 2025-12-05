package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Kho
 */
@Entity
@Table(name = "kho")
public class Kho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "mat_hang_id")
    private MatHang matHang;
    
    @Column(name = "so_luong_tong")
    private Integer soLuongTong;
    
    @Column(name = "so_luong_con")
    private Integer soLuongCon;
    
    @Column(name = "vi_tri_kho")
    private String viTriKho;

    // Constructors
    public Kho() {}

    public Kho(MatHang matHang, Integer soLuongTong, Integer soLuongCon, String viTriKho) {
        this.matHang = matHang;
        this.soLuongTong = soLuongTong;
        this.soLuongCon = soLuongCon;
        this.viTriKho = viTriKho;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }

    public Integer getSoLuongTong() {
        return soLuongTong;
    }

    public void setSoLuongTong(Integer soLuongTong) {
        this.soLuongTong = soLuongTong;
    }

    public Integer getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(Integer soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public String getViTriKho() {
        return viTriKho;
    }

    public void setViTriKho(String viTriKho) {
        this.viTriKho = viTriKho;
    }
}
