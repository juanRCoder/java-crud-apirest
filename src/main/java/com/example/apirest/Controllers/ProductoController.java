package com.example.apirest.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.Entities.Producto;
import com.example.apirest.Services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService; // instancia de service

    @GetMapping
    public List<Producto> getAll() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable UUID id) {
        return productoService.getById(id);
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoService.create(producto);
    }

    @PutMapping("/{id}")
    public Producto update(@PathVariable UUID id, @RequestBody Producto detailProduct) {
        return productoService.update(id, detailProduct);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        return productoService.delete(id);
    }
}
