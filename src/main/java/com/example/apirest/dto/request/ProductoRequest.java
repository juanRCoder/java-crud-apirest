package com.example.apirest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;

@Data
public class ProductoRequest {
    @NotBlank(message = "El nombre es requerido.")
    private String nombre;
    @NotNull(message = "El precio es requerido.")
    @Positive(message = "El precio debe ser mayor a 0.")
    private double precio;
}
