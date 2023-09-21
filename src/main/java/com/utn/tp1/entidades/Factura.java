package com.utn.tp1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int idFactura;

    @Column(name="Forma de pago")
    private String formaPago;

    @Column(name="Número")
    private int numero;

    @Column(name="Fecha")
    private Date fecha;

    @Column(name ="Descuento")
    private double descuento;

    @Column(name="Total")
    private int total;

    @OneToOne(mappedBy = "factura")
    private Pedido pedido;
}
