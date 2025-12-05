package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.DatTiec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatTiecRepository extends JpaRepository<DatTiec, Long> {
}
