package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.GoiTiec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoiTiecRepository extends JpaRepository<GoiTiec, Integer> {
}
