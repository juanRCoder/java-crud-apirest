package com.example.apirest.dto.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
}
