package com.feedback2.proyectosmg.mision.repository;

import com.feedback2.proyectosmg.mision.model.MisionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MisionRepository extends JpaRepository<MisionData, Long> {
}

