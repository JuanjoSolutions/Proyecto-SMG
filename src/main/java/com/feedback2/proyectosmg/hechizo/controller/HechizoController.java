package com.feedback2.proyectosmg.hechizo.controller;

import com.feedback2.proyectosmg.hechizo.model.Hechizo;
import com.feedback2.proyectosmg.hechizo.service.HechizoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hechizos")
public class HechizoController {

    @Autowired
    private HechizoService hechizoService;

    @PostMapping
    public ResponseEntity<Hechizo> guardarHechizo(@RequestBody Hechizo hechizo) {
        Hechizo nuevoHechizo = hechizoService.guardarHechizo(hechizo);
        return ResponseEntity.ok(nuevoHechizo);
    }

    @GetMapping
    public ResponseEntity<List<Hechizo>> obtenerTodosHechizos() {
        List<Hechizo> hechizos = hechizoService.obtenerTodosHechizos();
        return ResponseEntity.ok(hechizos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hechizo> obtenerHechizoPorId(@PathVariable Long id) {
        Hechizo hechizo = hechizoService.obtenerHechizoPorId(id);
        return ResponseEntity.ok(hechizo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hechizo> actualizarHechizo(@PathVariable Long id, @RequestBody Hechizo hechizoDetalles) {
        Hechizo hechizoActualizado = hechizoService.actualizarHechizo(id, hechizoDetalles);
        return ResponseEntity.ok(hechizoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHechizo(@PathVariable Long id) {
        hechizoService.eliminarHechizo(id);
        return ResponseEntity.noContent().build();
    }
}

