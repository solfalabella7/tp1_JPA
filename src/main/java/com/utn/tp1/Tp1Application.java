package com.utn.tp1;

import com.utn.tp1.entidades.*;
import com.utn.tp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class Tp1Application {
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	FacturaRepository facturaRepo;
	@Autowired
	PedidoRepository pedidoRepo;
	@Autowired
	PorductoRepository productoRepo;
	@Autowired
	DetallePedidoRepository detalleRepo;
	@Autowired
	DomicilioRepository domicilioRepo;
	@Autowired
	RubroRepository rubroRepo;

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
        System.out.println("Funciono correctamente.");
	}
	@Bean
	CommandLineRunner init(FacturaRepository facturaRepo, PedidoRepository pedidoRepo, ClienteRepository clienteRepo){
		return args -> {
			DetallePedido detalle1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(22)
					.build();

			Factura factura1 = Factura.builder()
					.total(500)
					.descuento(0)
					.formaPago("Efectivo")
					.fecha(new Date())
					.build();
			facturaRepo.save(factura1);

			Pedido pedido1 = Pedido.builder()
					.estado("entregado")
					.fecha(new Date())
					.tipoEnvio("Delivery")
					.factura(factura1)
					.total(350)
					.build();
			//pedido1.agregarDetalle(detalle1);

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Libertad")
					.numero("94")
					.localidad("San Rafael")
					.build();

			Cliente cliente1 = Cliente.builder()
					.nombre("Carlos")
					.apellido("Bala")
					.telefono("2222")
					.email("hola@gmail.com")
					.build();
			clienteRepo.save(cliente1);
			//cliente1.agregarPedido(pedido1);
			//cliente1.agregarDomicilio(domicilio1);


		};
	}
}
