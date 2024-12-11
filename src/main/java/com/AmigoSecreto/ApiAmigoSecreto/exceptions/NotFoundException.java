package com.AmigoSecreto.ApiAmigoSecreto.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {}
    public NotFoundException(String message) {
        super("ID NOT FOUND");
    }
}
