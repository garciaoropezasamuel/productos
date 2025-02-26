package com.example.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productos.entities.Producto;

// repositorio que hereda las propiedades de JPA para realizar el mapeo con la entidad con Hibernate
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
