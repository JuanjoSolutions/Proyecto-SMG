package com.feedback2.proyectosmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.feedback2.proyectosmg.pedido.model",
        "com.feedback2.proyectosmg.dinosaurio.model",
        "com.feedback2.proyectosmg.hechizo.model",
        "com.feedback2.proyectosmg.mision.model"
})
public class ProyectoSmgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoSmgApplication.class, args);
    }
}
