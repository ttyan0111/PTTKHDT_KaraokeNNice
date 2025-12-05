package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.Kho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoRepository extends JpaRepository<Kho, Long> {
}
