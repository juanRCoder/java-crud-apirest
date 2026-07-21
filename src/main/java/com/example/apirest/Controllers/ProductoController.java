package com.example.apirest.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.apirest.Services.ProductoService;
import com.example.apirest.dto.request.ProductoRequest;
import com.example.apirest.dto.response.ProductoResponse;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService; // instancia de service

    @GetMapping
    public List<ProductoResponse> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ProductoResponse getById(@PathVariable UUID id) {
        return productoService.getById(id);
    }

    @PostMapping
    public ProductoResponse create(@RequestBody ProductoRequest producto) {
        return productoService.create(producto);
    }

    @PutMapping("/{id}")
    public ProductoResponse update(@PathVariable UUID id, @RequestBody ProductoRequest data) {
        return productoService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        return productoService.delete(id);
    }
}
