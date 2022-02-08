package com.bizao.gestionvol.exceptions;

public enum ErrorCodes
{
    FLIGHT_NOT_FOUND(1000),
    FLIGHT_NOT_VALID(1001),
    COMPANY_NOT_FOUND(2000),
    COMPANY_NOT_VALID(2001),
    COUNTRY_NOT_FOUND(3000),
    COUNTRY_NOT_VALID(3001),
    CITY_NOT_FOUND(4000),
    CITY_NOT_VALIDE(4001),
    AIRPORT_NOT_FOUND(5000),
    AIRPORT_NOT_VALID(5001);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
