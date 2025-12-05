package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.PhieuKiemKe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuKiemKeRepository extends JpaRepository<PhieuKiemKe, Integer> {
}
