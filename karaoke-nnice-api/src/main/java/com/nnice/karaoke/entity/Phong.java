package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Entity đại diện cho Phòng
 */
@Entity
@Table(name = "Phong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhong")
    private Integer maPhong;
    
    @Column(name = "TenPhong", length = 50, nullable = false)
    private String tenPhong;
    
    @Column(name = "TrangThai", length = 50, nullable = false)
    private String trangThai; // "Trống", "Đã đặt", "Đang sử dụng", "Bảo trì"
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaCS", referencedColumnName = "MaCS")
    private CoSo coSo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaLoai", referencedColumnName = "MaLoai")
    private LoaiPhong loaiPhong;
    
    @OneToMany(mappedBy = "phong", cascade = CascadeType.ALL)
    private List<PhieuSuDung> phieuSuDungList;
}
