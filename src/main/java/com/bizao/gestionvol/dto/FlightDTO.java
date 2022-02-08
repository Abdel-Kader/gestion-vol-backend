package com.bizao.gestionvol.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class FlightDTO
{
    private Integer id;

    private LocalDateTime creationDate;

    private String flightID;

    private Date takeOffDate;

    private Date landingDate;

    private Date duration;

    private CompanyDTO company;

    private CityDTO takeOffCity;

    private CityDTO landingCity;

    private String className;

    private double classPrice;

}
