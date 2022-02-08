package com.bizao.gestionvol.exceptions;

import lombok.Getter;

import java.util.List;

public class InvalideEntityException extends RuntimeException {

    @Getter
    private ErrorCodes errorCode;

    @Getter
    private List<String> errors;

    public InvalideEntityException(String message) {
        super(message);
    }

    public InvalideEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalideEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalideEntityException(String message, Throwable cause, ErrorCodes errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalideEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
