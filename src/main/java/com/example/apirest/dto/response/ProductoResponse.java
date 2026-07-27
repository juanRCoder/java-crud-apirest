package com.example.apirest.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoResponse {
    private String id;
    private String nombre;
    private double precio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
