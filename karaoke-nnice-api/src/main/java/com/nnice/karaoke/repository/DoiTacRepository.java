package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.DoiTac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoiTacRepository extends JpaRepository<DoiTac, Integer> {
}
