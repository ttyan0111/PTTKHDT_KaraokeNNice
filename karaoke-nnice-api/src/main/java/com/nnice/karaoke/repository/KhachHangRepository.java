package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository cho KhachHang
 */
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    
    // Tìm khách hàng theo số điện thoại
    Optional<KhachHang> findBySdt(String sdt);
    
    // Tìm khách hàng theo email
    Optional<KhachHang> findByEmail(String email);
    
    // Kiểm tra tồn tại theo SĐT
    boolean existsBySdt(String sdt);
}
