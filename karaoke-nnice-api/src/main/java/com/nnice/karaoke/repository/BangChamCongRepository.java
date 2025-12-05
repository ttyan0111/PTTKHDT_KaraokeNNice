package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.BangChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BangChamCongRepository extends JpaRepository<BangChamCong, Integer> {
}
