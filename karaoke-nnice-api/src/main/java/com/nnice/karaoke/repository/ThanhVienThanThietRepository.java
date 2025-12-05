package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.ThanhVienThanThiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThanhVienThanThietRepository extends JpaRepository<ThanhVienThanThiet, Long> {
}
