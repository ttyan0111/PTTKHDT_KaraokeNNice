package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity đại diện cho Khách Hàng
 */
@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KhachHang {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKH")
    private Integer maKhach;
    
    @Column(name = "TenKH", nullable = false, length = 100)
    private String tenKH;
    
    @Column(name = "SDT", unique = true, length = 15)
    private String sdt;
    
    @Column(name = "Email", length = 100)
    private String email;
    
    @Column(name = "LoaiKhach", length = 50)
    private String loaiKhach;
}
