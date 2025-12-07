package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

/**
 * Entity đại diện cho Thẻ Thành Viên
 */
@Entity
@Table(name = "TheThanhVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheThanhVien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThe")
    private Integer maThe;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKH", nullable = false, unique = true)
    private KhachHang khachHang;
    
    @Column(name = "HangThe", length = 50)
    private String hangThe;
    
    @Column(name = "DiemTichLuy")
    @Builder.Default
    private Integer diemTichLuy = 0;
    
    @Column(name = "NgayCap")
    private LocalDate ngayCap;
}

