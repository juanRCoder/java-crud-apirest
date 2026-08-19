package com.example.apirest.service;

import org.springframework.stereotype.Service;

import com.example.apirest.dto.request.ProductoRequest;
import com.example.apirest.dto.response.ProductoResponse;
import com.example.apirest.exception.NotFoundException;
import com.example.apirest.mapper.ProductoMapper;
import com.example.apirest.model.Producto;
import com.example.apirest.repository.ProductoRepository;

import java.util.*;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
        }


    public List<ProductoResponse> getAll() {
        List<Producto> productos = productoRepository.findAll();

        List<ProductoResponse> response = new ArrayList<>();
        for (Producto p : productos) {
            response.add(productoMapper.toResponse(p));
        }
        return response;
    }

    public ProductoResponse getById(UUID id) {
        Producto producto = productoRepository.findById(id)
               .orElseThrow(() -> new NotFoundException(
                    "PRODUCT_NOT_FOUND",
                    "El producto con id " + id + " no se encontro."
                ));
        return productoMapper.toResponse(producto);
    }

    public ProductoResponse create(ProductoRequest data) {
       Producto producto = productoMapper.toEntity(data);
       Producto created = productoRepository.save(producto);
       return productoMapper.toResponse(created);
    }

    public ProductoResponse update(UUID id, ProductoRequest data) {
        Producto producto = productoRepository.findById(id)
               .orElseThrow(() -> new NotFoundException(
                    "PRODUCT_NOT_FOUND",
                    "El producto con id " + id + " no se encontro."
                ));

        if (data.getNombre() != null) {
            producto.setNombre(data.getNombre());
        }
        if (data.getPrecio() != 0) {
            producto.setPrecio(data.getPrecio());
        }

        Producto updated = productoRepository.save(producto);
        return productoMapper.toResponse(updated);
    }

    public String delete(UUID id) {
        if (!productoRepository.existsById(id)) {
            throw new NotFoundException(
                "PRODUCT_NOT_FOUND",
                "El producto con id " + id + " no se encontro."
            );
        }

        productoRepository.deleteById(id);
        return "El producto " + id + " fue eliminado correctamente!";
    }
}
