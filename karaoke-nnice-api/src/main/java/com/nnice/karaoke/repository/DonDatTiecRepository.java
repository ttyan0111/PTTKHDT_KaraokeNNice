package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.DonDatTiec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonDatTiecRepository extends JpaRepository<DonDatTiec, Integer> {
}
