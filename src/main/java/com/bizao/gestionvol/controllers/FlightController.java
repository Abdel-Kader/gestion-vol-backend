package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.FlightAPI;
import com.bizao.gestionvol.dto.FlightDTO;
import com.bizao.gestionvol.services.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://kind-ardinghelli-54180a.netlify.app")
public class FlightController implements FlightAPI
{
    private final FlightService flightService;

    @Override
    public ResponseEntity<FlightDTO> saveFlight(FlightDTO dto)
    {
        FlightDTO flight = flightService.save(dto);
        return ResponseEntity.ok(flight);
    }

    @Override
    public ResponseEntity<List<FlightDTO>> findAll()
    {
        List<FlightDTO> flightDTOList = flightService.findAll();
        return ResponseEntity.ok(flightDTOList);
    }

    @Override
    public ResponseEntity<List<FlightDTO>> compareFlight(Integer takeOffCity, Integer landingCity, String date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date takeOffDate = dateFormat.parse(date);
        List<FlightDTO> flightDTOList = flightService.comparePrice(takeOffCity, landingCity, takeOffDate);
        return ResponseEntity.ok(flightDTOList);
    }

    @Override
    public ResponseEntity<FlightDTO> findByFlightID(String flightID)
    {
        FlightDTO flight = flightService.findByFlightID(flightID);
        return ResponseEntity.ok(flight);
    }
}
