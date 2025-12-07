package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "BangChamCong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BangChamCong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChamCong")
    private Integer maChamCong;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaCa", nullable = false)
    private CaLamViec caLamViec;
    
    @Column(name = "NgayLam")
    private LocalDate ngayLam;
    
    @Column(name = "GioCheckIn")
    private LocalDateTime gioCheckIn;
    
    @Column(name = "GioCheckOut")
    private LocalDateTime gioCheckOut;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
}
