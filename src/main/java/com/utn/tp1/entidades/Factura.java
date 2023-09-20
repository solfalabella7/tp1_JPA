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
    private int idFactura;
    private String formaPago;
    private int numero;
    private Date fecha;
    private double descuento;
    private int total;
    @OneToOne(mappedBy = "factura")
    private Pedido pedido;
}
