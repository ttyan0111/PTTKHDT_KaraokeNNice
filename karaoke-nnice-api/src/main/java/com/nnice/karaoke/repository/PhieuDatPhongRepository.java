package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.PhieuDatPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository cho PhieuDatPhong
 */
@Repository
public interface PhieuDatPhongRepository extends JpaRepository<PhieuDatPhong, Integer> {
    
    // Tìm phiếu đặt theo khách hàng
    List<PhieuDatPhong> findByKhachHang_MaKhach(Integer maKhach);
    
    // Tìm phiếu đặt theo phòng và trạng thái khác
    List<PhieuDatPhong> findByPhong_MaPhongAndTrangThaiNot(Integer maPhong, String trangThai);
    
    // Tìm phiếu đặt theo số điện thoại khách
    @Query("SELECT p FROM PhieuDatPhong p WHERE p.khachHang.sdt = :sdt ORDER BY p.ngayDat DESC")
    List<PhieuDatPhong> findBySoDienThoai(@Param("sdt") String sdt);
    
    // Tìm phiếu đặt theo trạng thái
    List<PhieuDatPhong> findByTrangThai(String trangThai);
    
    // Tìm phiếu đặt trong khoảng thời gian
    @Query("SELECT p FROM PhieuDatPhong p WHERE p.gioDat >= :tuNgay AND p.gioKetThuc <= :denNgay")
    List<PhieuDatPhong> findByThoiGian(@Param("tuNgay") LocalDateTime tuNgay, @Param("denNgay") LocalDateTime denNgay);
}

