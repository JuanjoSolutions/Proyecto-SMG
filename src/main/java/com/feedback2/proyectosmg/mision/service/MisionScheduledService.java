package com.feedback2.proyectosmg.mision.service;

import com.feedback2.proyectosmg.mision.model.MisionData;
import com.feedback2.proyectosmg.mision.repository.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class MisionScheduledService {

    @Autowired
    private MisionRepository misionRepository;

    // Ejecutar cada hora (puedes ajustar la frecuencia según tus necesidades)
    @Scheduled(cron = "0 0 * * * *")
    public void exportarDatosMision() {
        List<MisionData> datos = misionRepository.findByTimestampAfter(LocalDateTime.now().minusDays(1));

        try (FileWriter writer = new FileWriter("mision-output.csv")) {
            writer.append("id,sensor,valor,timestamp\n");
            for (MisionData dato : datos) {
                writer.append(dato.getId().toString()).append(",");
                writer.append(dato.getSensor()).append(",");
                writer.append(dato.getValor().toString()).append(",");
                writer.append(dato.getTimestamp().toString()).append("\n");
            }
            System.out.println("Datos de misión exportados exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

