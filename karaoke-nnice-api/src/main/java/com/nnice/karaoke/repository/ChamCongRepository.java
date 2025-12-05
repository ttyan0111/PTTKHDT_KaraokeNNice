package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.ChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong, Long> {
}
