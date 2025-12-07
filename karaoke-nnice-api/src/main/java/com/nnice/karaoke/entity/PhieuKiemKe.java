package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PhieuKiemKe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhieuKiemKe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKiemKe")
    private Integer maKiemKe;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNV", nullable = false)
    private NhanVien nhanVien;
    
    @Column(name = "NgayKiem")
    private LocalDateTime ngayKiem;
    
    @Column(name = "KyKiem", length = 50)
    private String kyKiem;
}
