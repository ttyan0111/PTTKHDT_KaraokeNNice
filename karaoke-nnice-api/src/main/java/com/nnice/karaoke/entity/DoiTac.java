package com.nnice.karaoke.entity;

import jakarta.persistence.*;

/**
 * Entity đại diện cho Đối Tác
 */
@Entity
@Table(name = "DoiTac")
public class DoiTac {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDT")
    private Integer maDT;
    
    @Column(name = "TenDT", length = 100)
    private String tenDT;
    
    @Column(name = "SDT", length = 15)
    private String sdt;
    
    @Column(name = "TyLeHoaHong")
    private Float tyLeHoaHong;

    // Constructors
    public DoiTac() {}

    public DoiTac(String tenDT, String sdt, Float tyLeHoaHong) {
        this.tenDT = tenDT;
        this.sdt = sdt;
        this.tyLeHoaHong = tyLeHoaHong;
    }

    // Getters and Setters
    public Integer getMaDT() {
        return maDT;
    }

    public void setMaDT(Integer maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Float getTyLeHoaHong() {
        return tyLeHoaHong;
    }

    public void setTyLeHoaHong(Float tyLeHoaHong) {
        this.tyLeHoaHong = tyLeHoaHong;
    }

    @Override
    public String toString() {
        return "DoiTac{" +
                "maDT=" + maDT +
                ", tenDT='" + tenDT + '\'' +
                ", sdt='" + sdt + '\'' +
                ", tyLeHoaHong=" + tyLeHoaHong +
                '}';
    }
}
