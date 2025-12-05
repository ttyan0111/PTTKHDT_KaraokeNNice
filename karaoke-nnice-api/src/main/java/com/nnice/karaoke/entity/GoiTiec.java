package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity đại diện cho Gói Tiệc
 */
@Entity
@Table(name = "GoiTiec")
public class GoiTiec {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaGoi")
    private Integer maGoi;
    
    @Column(name = "TenGoi", length = 100)
    private String tenGoi;
    
    @Column(name = "GiaTronGoi")
    private BigDecimal giaTronGoi;

    // Constructors
    public GoiTiec() {}

    public GoiTiec(String tenGoi, BigDecimal giaTronGoi) {
        this.tenGoi = tenGoi;
        this.giaTronGoi = giaTronGoi;
    }

    // Getters and Setters
    public Integer getMaGoi() {
        return maGoi;
    }

    public void setMaGoi(Integer maGoi) {
        this.maGoi = maGoi;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public BigDecimal getGiaTronGoi() {
        return giaTronGoi;
    }

    public void setGiaTronGoi(BigDecimal giaTronGoi) {
        this.giaTronGoi = giaTronGoi;
    }

    @Override
    public String toString() {
        return "GoiTiec{" +
                "maGoi=" + maGoi +
                ", tenGoi='" + tenGoi + '\'' +
                ", giaTronGoi=" + giaTronGoi +
                '}';
    }
}
