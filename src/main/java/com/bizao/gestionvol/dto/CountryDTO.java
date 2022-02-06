package com.bizao.gestionvol.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CountryDTO
{
    private Integer id;

    private String countryName;

    private LocalDateTime creationDate;

}
