package com.feedback2.proyectosmg.hechizo.repository;

import com.feedback2.proyectosmg.hechizo.model.Hechizo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HechizoRepository extends JpaRepository<Hechizo, Long> {
}

