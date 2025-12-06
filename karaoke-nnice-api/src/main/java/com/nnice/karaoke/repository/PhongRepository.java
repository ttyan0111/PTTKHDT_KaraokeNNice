package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.Phong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository cho Phong
 */
@Repository
public interface PhongRepository extends JpaRepository<Phong, Integer> {
    
    // Tìm phòng theo trạng thái
    List<Phong> findByTrangThai(String trangThai);
    
    // Tìm phòng theo cơ sở
    List<Phong> findByCoSo_MaCS(Integer maCoSo);
    
    // Tìm phòng theo loại phòng có sức chứa >= yêu cầu
    List<Phong> findByLoaiPhong_SucChuaGreaterThanEqual(Integer sucChua);
    
    // Tìm phòng theo cơ sở và sức chứa
    @Query("SELECT p FROM Phong p WHERE p.coSo.maCS = :maCoSo AND p.loaiPhong.sucChua >= :sucChua")
    List<Phong> findByCoSoAndSucChua(@Param("maCoSo") Integer maCoSo, @Param("sucChua") Integer sucChua);
    
    // Tìm phòng trống với JOIN FETCH để load LoaiPhong
    @Query("SELECT p FROM Phong p LEFT JOIN FETCH p.loaiPhong WHERE p.trangThai = 'Trong' OR p.trangThai = 'San sang'")
    List<Phong> findPhongTrong();
}
