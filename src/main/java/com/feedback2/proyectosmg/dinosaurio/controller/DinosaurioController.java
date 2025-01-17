package com.feedback2.proyectosmg.dinosaurio.controller;

import com.feedback2.proyectosmg.dinosaurio.model.Dinosaurio;
import com.feedback2.proyectosmg.dinosaurio.service.DinosaurioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dinosaurios")
public class DinosaurioController {

    @Autowired
    private DinosaurioService dinosaurioService;

    @PostMapping
    public ResponseEntity<Dinosaurio> guardarDinosaurio(@RequestBody Dinosaurio dinosaurio) {
        Dinosaurio nuevoDinosaurio = dinosaurioService.guardarDinosaurio(dinosaurio);
        return ResponseEntity.ok(nuevoDinosaurio);
    }

    @GetMapping
    public ResponseEntity<List<Dinosaurio>> obtenerTodosDinosaurios() {
        List<Dinosaurio> dinosaurios = dinosaurioService.obtenerTodosDinosaurios();
        return ResponseEntity.ok(dinosaurios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dinosaurio> obtenerDinosaurioPorId(@PathVariable Long id) {
        Dinosaurio dinosaurio = dinosaurioService.obtenerDinosaurioPorId(id);
        return ResponseEntity.ok(dinosaurio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dinosaurio> actualizarDinosaurio(@PathVariable Long id, @RequestBody Dinosaurio dinosaurioDetalles) {
        Dinosaurio dinosaurioActualizado = dinosaurioService.actualizarDinosaurio(id, dinosaurioDetalles);
        return ResponseEntity.ok(dinosaurioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDinosaurio(@PathVariable Long id) {
        dinosaurioService.eliminarDinosaurio(id);
        return ResponseEntity.noContent().build();
    }
}

