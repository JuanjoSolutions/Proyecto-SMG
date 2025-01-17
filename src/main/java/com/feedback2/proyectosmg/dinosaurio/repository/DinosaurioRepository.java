package com.feedback2.proyectosmg.dinosaurio.repository;

import com.feedback2.proyectosmg.dinosaurio.model.Dinosaurio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DinosaurioRepository extends JpaRepository<Dinosaurio, Long> {
}

