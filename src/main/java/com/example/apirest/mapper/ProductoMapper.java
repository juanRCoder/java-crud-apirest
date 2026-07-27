package com.example.apirest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.apirest.dto.request.ProductoRequest;
import com.example.apirest.dto.response.ProductoResponse;
import com.example.apirest.model.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Producto toEntity(ProductoRequest request);

    ProductoResponse toResponse(Producto producto);
}
