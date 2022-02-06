package com.bizao.gestionvol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CityDTO
{
    private Integer id;

    private LocalDateTime creationDate;

    private String cityName;

    private CountryDTO country;
}
