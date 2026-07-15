package com.example.apirest.Services;

import org.springframework.stereotype.Service;

import com.example.apirest.Entities.Producto;
import com.example.apirest.Repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public Producto getById(UUID id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con id: " + id + " no encontrado"));
    }

    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(UUID id, Producto detailProduct) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con id: " + id + " no encontrado"));

        producto.setNombre(detailProduct.getNombre());
        producto.setPrecio(detailProduct.getPrecio());
        return productoRepository.save(producto);
    }

    public String delete(UUID id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto con id: " + id + " no encontrado"));

        productoRepository.delete(producto);
        return "El producto " + producto.getNombre() + " fue eliminado correctamente!";
    }
}
