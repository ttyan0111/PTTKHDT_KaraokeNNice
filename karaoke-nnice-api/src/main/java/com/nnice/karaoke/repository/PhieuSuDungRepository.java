package com.nnice.karaoke.repository;

import com.nnice.karaoke.entity.PhieuSuDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuSuDungRepository extends JpaRepository<PhieuSuDung, Integer> {
}
