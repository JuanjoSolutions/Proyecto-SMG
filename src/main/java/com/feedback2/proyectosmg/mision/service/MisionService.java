package com.feedback2.proyectosmg.mision.service;

import com.feedback2.proyectosmg.mision.model.MisionData;
import com.feedback2.proyectosmg.mision.repository.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionService {

    @Autowired
    private MisionRepository misionRepository;

    public List<MisionData> obtenerTodosDatos() {
        return misionRepository.findAll();
    }

    public MisionData guardarDato(MisionData dato) {
        return misionRepository.save(dato);
    }
}

