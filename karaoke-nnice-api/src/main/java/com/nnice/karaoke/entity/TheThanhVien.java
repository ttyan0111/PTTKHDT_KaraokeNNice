package com.nnice.karaoke.entity;

import javax.persistence.*;

/**
 * Entity đại diện cho Thành Viên Thân Thiết
 */
@Entity
@Table(name = "The_Thanh_Vien")
public class TheThanhVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "Ma_The")
    private String maThe;
    
    @Column(name = "Hang_The")
    private String hangThe;
    
    @Column(name = "Diem_Tich_Luy")
    private Long tongDiem;
    
    @Column(name = "Ngay_Cap")
    private String trangThai;

    // Constructors
    public ThanhVienThanThiet() {}

    public ThanhVienThanThiet(String maThe, String hangThe, Long tongDiem, String trangThai) {
        this.maThe = maThe;
        this.hangThe = hangThe;
        this.tongDiem = tongDiem;
        this.trangThai = trangThai;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }   
}
