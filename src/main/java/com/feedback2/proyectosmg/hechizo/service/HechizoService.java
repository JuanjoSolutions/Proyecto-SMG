package com.feedback2.proyectosmg.hechizo.service;

import com.feedback2.proyectosmg.hechizo.model.Hechizo;
import com.feedback2.proyectosmg.hechizo.repository.HechizoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HechizoService {

    @Autowired
    private HechizoRepository hechizoRepository;

    public Hechizo guardarHechizo(Hechizo hechizo) {
        hechizo.setTimestamp(LocalDateTime.now());
        return hechizoRepository.save(hechizo);
    }

    public List<Hechizo> obtenerTodosHechizos() {
        return hechizoRepository.findAll();
    }

    public Hechizo obtenerHechizoPorId(Long id) {
        return hechizoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hechizo no encontrado"));
    }

    public Hechizo actualizarHechizo(Long id, Hechizo hechizoDetalles) {
        Hechizo hechizo = obtenerHechizoPorId(id);
        hechizo.setNombre(hechizoDetalles.getNombre());
        hechizo.setDescripcion(hechizoDetalles.getDescripcion());
        hechizo.setNivel(hechizoDetalles.getNivel());
        return hechizoRepository.save(hechizo);
    }

    public void eliminarHechizo(Long id) {
        Hechizo hechizo = obtenerHechizoPorId(id);
        hechizoRepository.delete(hechizo);
    }
}

