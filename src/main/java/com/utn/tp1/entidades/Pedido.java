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
@Table(name = "Pedido")
@Builder
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long idPedido;
    private String estado;
    private Date fecha;
    private double total;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foregin key")
    private Factura factura;

}
