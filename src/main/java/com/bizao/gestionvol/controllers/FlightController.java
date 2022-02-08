package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.FlightAPI;
import com.bizao.gestionvol.dto.FlightDTO;
import com.bizao.gestionvol.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController implements FlightAPI
{
    private final FlightService flightService;

    @Override
    public FlightDTO saveFlight(FlightDTO dto)
    {
        return flightService.save(dto);
    }

    @Override
    public List<FlightDTO> findAll()
    {
        return flightService.findAll();
    }

    @Override
    public List<FlightDTO> compareFlight(Integer takeOffCity, Integer landingCity, String date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date takeOffDate = dateFormat.parse(date);
        return flightService.comparePrice(takeOffCity, landingCity, takeOffDate);
    }

    @Override
    public FlightDTO findByFlightID(String flightID)
    {
        return flightService.findByFlightID(flightID);
    }
}
