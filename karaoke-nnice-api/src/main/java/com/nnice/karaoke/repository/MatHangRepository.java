package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.MatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatHangRepository extends JpaRepository<MatHang, Long> {
}
