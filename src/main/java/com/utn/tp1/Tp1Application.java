package com.utn.tp1;

import com.utn.tp1.entidades.*;
import com.utn.tp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Tp1Application {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	FacturaRepository facturaRepo;
	@Autowired
	PedidoRepository pedidoRepo;

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
        System.out.println("Funciono correctamente.");

	}
	@Bean
	CommandLineRunner init(FacturaRepository facturaRepo, PedidoRepository pedidoRepo){
		return args -> {

			Pedido pedido1 = Pedido.builder()
					.estado = "entregado"
					.build();

		};
	}
}
