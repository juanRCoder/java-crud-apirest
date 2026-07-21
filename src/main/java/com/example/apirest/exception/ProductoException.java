package com.example.apirest.exception;

import java.util.UUID;

public class ProductoException extends RuntimeException {
    public ProductoException(UUID id) {
        super("El producto con id: " + id + " no fue encontrado");
    }
}
