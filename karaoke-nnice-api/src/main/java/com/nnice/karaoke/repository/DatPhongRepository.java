package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.DatPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatPhongRepository extends JpaRepository<DatPhong, Long> {
}
