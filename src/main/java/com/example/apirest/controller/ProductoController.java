package com.example.apirest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.apirest.dto.request.ProductoRequest;
import com.example.apirest.dto.response.ProductoResponse;
import com.example.apirest.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoResponse> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoResponse getById(@PathVariable UUID id) {
        return productoService.getById(id);
    }

    @PostMapping
    public ProductoResponse create(@RequestBody @Valid ProductoRequest producto) {
        return productoService.create(producto);
    }

    @PatchMapping("/{id}")
    public ProductoResponse update(@PathVariable UUID id, @RequestBody ProductoRequest data) {
        return productoService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        return productoService.delete(id);
    }
}
