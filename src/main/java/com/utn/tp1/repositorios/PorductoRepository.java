package com.utn.tp1.repositorios;

import com.utn.tp1.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorductoRepository extends JpaRepository<Producto, Long> {
}
