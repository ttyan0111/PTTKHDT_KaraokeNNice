package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.CoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoSoRepository extends JpaRepository<CoSo, Long> {
}
