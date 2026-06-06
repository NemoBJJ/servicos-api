package com.gestex.servicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicosApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicosApiApplication.class, args);
        System.out.println("🚀 Serviços API rodando na porta 8084!");
    }
}