package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.CauHinhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauHinhGiaRepository extends JpaRepository<CauHinhGia, Integer> {
}
