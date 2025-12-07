package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "CoSo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoSo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaCS")
    private Integer maCS;
    
    @Column(name = "TenCS", nullable = false, length = 100)
    private String tenCS;
    
    @Column(name = "DiaChi", length = 255)
    private String diaChi;
    
    @Column(name = "SDT", length = 15)
    private String sdt;
    
    @OneToMany(mappedBy = "coSo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phong> phongs;
    
    @OneToMany(mappedBy = "coSo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NhanVien> nhanViens;
}
