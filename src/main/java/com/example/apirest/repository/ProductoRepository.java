package com.example.apirest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {
    // findById, save, findAll ya vienen incluidos
}
