package com.example.apirest.Services;

import org.springframework.stereotype.Service;

import com.example.apirest.Entities.Producto;
import com.example.apirest.Repositories.ProductoRepository;
import com.example.apirest.dto.request.ProductoRequest;
import com.example.apirest.dto.response.ProductoResponse;
import com.example.apirest.exception.ProductoException;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoResponse> getAll() {
        List<Producto> productos = productoRepository.findAll();

        List<ProductoResponse> response = new ArrayList<>();
        for (Producto p : productos) {
            response.add(toResponse(p)); // convierto cada uno
        }
        return response;
    }

    public ProductoResponse getById(UUID id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoException(id));
        return toResponse(producto);
    }

    public ProductoResponse create(ProductoRequest data) {
       Producto producto = new Producto();
        producto.setNombre(data.getNombre());
        producto.setPrecio(data.getPrecio());

        Producto created = productoRepository.save(producto);
        return toResponse(created);
    }

    public ProductoResponse update(UUID id, ProductoRequest data) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoException(id));

        if (data.getNombre() != null) {
            producto.setNombre(data.getNombre());
        }
        if (data.getPrecio() != 0) {
            producto.setPrecio(data.getPrecio());
        }

        Producto updated = productoRepository.save(producto);
        return toResponse(updated);
    }

    public String delete(UUID id) {
        productoRepository.findById(id)
                .orElseThrow(() -> new ProductoException(id));

        productoRepository.deleteById(id);
        return "El producto " + id + " fue eliminado correctamente!";
    }


    //mapeo
    private ProductoResponse toResponse(Producto producto) {
        return new ProductoResponse(
            producto.getId().toString(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getCreatedAt(),
            producto.getUpdatedAt()
        );
    }
}
