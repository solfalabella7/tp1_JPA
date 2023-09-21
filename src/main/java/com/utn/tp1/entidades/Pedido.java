package com.utn.tp1.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private String tipoEnvio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foregin key")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="id_Pedido")
    private List<DetallePedido> detalles_lista = new ArrayList<>();

    public void agregarDetalle(DetallePedido detalle){
        detalles_lista.add(detalle);
    }

}
