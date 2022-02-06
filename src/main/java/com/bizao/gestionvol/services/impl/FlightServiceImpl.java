package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.dto.AirportDTO;
import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.dto.FlightDTO;
import com.bizao.gestionvol.entities.Flight;
import com.bizao.gestionvol.mappers.AirportMapper;
import com.bizao.gestionvol.mappers.CompanyMapper;
import com.bizao.gestionvol.mappers.FlightMapper;
import com.bizao.gestionvol.repositories.FlightRepository;
import com.bizao.gestionvol.services.FlightService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class FlightServiceImpl implements FlightService
{
    private final FlightRepository flightRepository;

    private final FlightMapper mapper;

    private final CompanyMapper companyMapper;

    private final AirportMapper airportMapper;

    @Override
    public FlightDTO save(FlightDTO dto)
    {
        Flight flight = flightRepository.save(mapper.flightDTOtoFlight(dto));
        log.info("Création d'un nouveau vol, {}", flight);
        return mapper.flightToFlightDTO(flight);
    }

    @Override
    public FlightDTO findById(Integer id)
    {
        Optional<Flight> flight = flightRepository.findById(id);
        log.info("Recherche d'un vol par son ID {}", id);
        return flight.map(mapper::flightToFlightDTO).orElse(null);
    }

    @Override
    public List<FlightDTO> findAll()
    {
        List<Flight> flightList = flightRepository.findAll();
        log.info("Liste des vols {}", flightList);
        return flightList.stream().map(mapper::flightToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {

    }

    @Override
    public FlightDTO findByFlightID(String flightID)
    {
        Optional<Flight> flight = flightRepository.findByFlightID(flightID);
        log.info("Recherche d'un vol par son numéro {}", flightID);
        return flight.map(mapper::flightToFlightDTO).orElse(null);
    }

    @Override
    public List<FlightDTO> comparePrice(Integer takeOffAirport, Integer landingAirport, Date takeOffDate)
    {
        List<Flight> flights = flightRepository.flightPriceComparaison(takeOffAirport, landingAirport, takeOffDate);
        log.info("Liste des vols quittant le {}", takeOffDate);
        return flights.stream().map(mapper::flightToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDTO> flightsByCompany(CompanyDTO companyDTO)
    {
        List<Flight> flights = flightRepository.findByCompany(companyMapper.companyDTOtoCompany(companyDTO));
        log.info("Liste des vols de la compagnie {}", companyDTO.getCompanyName());
        return flights.stream().map(mapper::flightToFlightDTO)
                .collect(Collectors.toList());
    }
}
