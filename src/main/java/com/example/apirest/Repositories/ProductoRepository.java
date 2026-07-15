package com.example.apirest.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apirest.Entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID> {
    // findById, save, findAll ya vienen incluidos gratis
}
