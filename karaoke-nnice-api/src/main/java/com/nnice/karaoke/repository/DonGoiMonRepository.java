package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.DonGoiMon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonGoiMonRepository extends JpaRepository<DonGoiMon, Integer> {
}
