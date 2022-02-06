package com.bizao.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AirportDTO
{
    private Integer id;

    private LocalDateTime creationDate;

    private String airportName;

    private CityDTO city;
}
