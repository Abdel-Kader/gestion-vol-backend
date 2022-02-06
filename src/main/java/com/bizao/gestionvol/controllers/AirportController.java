package com.bizao.gestionvol.controllers;

import lombok.AllArgsConstructor;
import com.bizao.gestionvol.dto.AirportDTO;
import com.bizao.gestionvol.services.AirportService;
import com.bizao.gestionvol.controllers.api.AirportAPI;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AirportController implements AirportAPI
{
    private AirportService airportService;

    @Override
    public AirportDTO saveAirport(AirportDTO airport)
    {
        return airportService.save(airport);
    }

    @Override
    public List<AirportDTO> findAll()
    {
        return airportService.findAll();
    }
}
