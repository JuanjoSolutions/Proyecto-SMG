package com.feedback2.proyectosmg.dinosaurio.service;

import com.feedback2.proyectosmg.dinosaurio.model.Dinosaurio;
import com.feedback2.proyectosmg.dinosaurio.repository.DinosaurioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DinosaurioService {

    @Autowired
    private DinosaurioRepository dinosaurioRepository;

    public Dinosaurio guardarDinosaurio(Dinosaurio dinosaurio) {
        dinosaurio.setTimestamp(LocalDateTime.now());
        return dinosaurioRepository.save(dinosaurio);
    }

    public List<Dinosaurio> obtenerTodosDinosaurios() {
        return dinosaurioRepository.findAll();
    }

    public Dinosaurio obtenerDinosaurioPorId(Long id) {
        return dinosaurioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dinosaurio no encontrado"));
    }

    public Dinosaurio actualizarDinosaurio(Long id, Dinosaurio dinosaurioDetalles) {
        Dinosaurio dinosaurio = obtenerDinosaurioPorId(id);
        dinosaurio.setTipo(dinosaurioDetalles.getTipo());
        dinosaurio.setUbicacion(dinosaurioDetalles.getUbicacion());
        dinosaurio.setTemperatura(dinosaurioDetalles.getTemperatura());
        return dinosaurioRepository.save(dinosaurio);
    }

    public void eliminarDinosaurio(Long id) {
        Dinosaurio dinosaurio = obtenerDinosaurioPorId(id);
        dinosaurioRepository.delete(dinosaurio);
    }
}
