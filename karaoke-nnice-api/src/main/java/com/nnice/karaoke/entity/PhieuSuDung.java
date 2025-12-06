package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entity đại diện cho Phiếu Sử Dụng
 * Ghi nhận thời gian thực tế khách sử dụng phòng (Check-in/Check-out)
 */
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
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhong", referencedColumnName = "MaPhong")
    private Phong phong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhieuDat", referencedColumnName = "MaPhieuDat")
    private PhieuDatPhong phieuDatPhong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    private NhanVien nhanVien;
    
    @Column(name = "GioBatDau")
    private LocalDateTime gioBatDau;
    
    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;
    
    @Column(name = "TongThoiGian")
    private Float tongThoiGian;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai; // "Đang sử dụng", "Đã kết thúc"

    // Business methods để tính toán thời gian
    public void tinhThoiGian() {
        if (gioBatDau != null && gioKetThuc != null) {
            this.tongThoiGian = (float) java.time.Duration.between(gioBatDau, gioKetThuc).toHours();
        }
    }
}
