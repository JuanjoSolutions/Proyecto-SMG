package com.feedback2.proyectosmg.mision.controller;

import com.feedback2.proyectosmg.mision.model.MisionData;
import com.feedback2.proyectosmg.mision.service.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/misiones")
public class MisionController {

    @Autowired
    private MisionService misionService;

    @PostMapping
    public ResponseEntity<MisionData> guardarDato(@RequestBody MisionData dato) {
        MisionData nuevoDato = misionService.guardarDato(dato);
        return ResponseEntity.ok(nuevoDato);
    }

    @GetMapping
    public ResponseEntity<List<MisionData>> obtenerTodosDatos() {
        List<MisionData> datos = misionService.obtenerTodosDatos();
        return ResponseEntity.ok(datos);
    }
}

