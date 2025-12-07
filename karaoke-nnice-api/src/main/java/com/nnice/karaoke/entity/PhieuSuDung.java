package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PhieuSuDung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuSuDung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPhieuSuDung")
    private Integer maPhieuSuDung;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong", nullable = false)
    private Phong phong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhieuDat")
    private PhieuDatPhong phieuDatPhong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;
    
    @Column(name = "GioBatDau")
    private LocalDateTime gioBatDau;
    
    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;
    
    @Column(name = "TongThoiGian")
    private Float tongThoiGian;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
    
    @OneToOne(mappedBy = "phieuSuDung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private HoaDon hoaDon;
    
    @OneToMany(mappedBy = "phieuSuDung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DonGoiMon> donGoiMons;
}
