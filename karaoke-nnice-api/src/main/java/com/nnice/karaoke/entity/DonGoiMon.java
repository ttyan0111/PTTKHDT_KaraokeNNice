package com.nnice.karaoke.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DonGoiMon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonGoiMon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaOrder")
    private Integer maOrder;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaPhieuSuDung", nullable = false)
    private PhieuSuDung phieuSuDung;
    
    @Column(name = "ThoiGianGoi")
    private LocalDateTime thoiGianGoi;
    
    @Column(name = "TrangThai", length = 50)
    private String trangThai;
}
