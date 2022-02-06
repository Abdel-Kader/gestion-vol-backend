package com.bizao.gestionvol.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

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

    private CompanyDTO company;

    private AirportDTO takeOffAirport;

    private AirportDTO landingAirport;

    private String className;

    private double classPrice;

}
