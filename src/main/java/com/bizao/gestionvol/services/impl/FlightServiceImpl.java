package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.dto.FlightDTO;
import com.bizao.gestionvol.entities.Flight;
import com.bizao.gestionvol.exceptions.EntityNotFoundException;
import com.bizao.gestionvol.exceptions.ErrorCodes;
import com.bizao.gestionvol.exceptions.InvalideEntityException;
import com.bizao.gestionvol.mappers.AirportMapper;
import com.bizao.gestionvol.mappers.CompanyMapper;
import com.bizao.gestionvol.mappers.FlightMapper;
import com.bizao.gestionvol.repositories.FlightRepository;
import com.bizao.gestionvol.services.FlightService;
import com.bizao.gestionvol.validators.FlightValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
        List<String> errors = FlightValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Flight not valid {}", dto);
            throw new InvalideEntityException("L'objet Flight n'est pas valide", ErrorCodes.FLIGHT_NOT_VALID);
        }
        Flight flight = flightRepository.save(mapper.flightDTOtoFlight(dto));
        log.info("Création d'un nouveau vol, {}", flight);
        return mapper.flightToFlightDTO(flight);
    }

    @Override
    public FlightDTO findById(Integer id)
    {
        if(id == null) {
            log.error("Flight ID is null");
            return null;
        }
        Optional<Flight> flight = flightRepository.findById(id);
        log.info("Recherche d'un vol par son ID {}", id);
        return flight.map(mapper::flightToFlightDTO)
                .orElseThrow(()-> new EntityNotFoundException(
                "Aucun vol avec l'ID = " + id + "n'a été trouvé",
                ErrorCodes.FLIGHT_NOT_FOUND
        ));
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
    public FlightDTO findByFlightID(String flightID)
    {
        if(!StringUtils.hasLength(flightID)) {
            log.error("Flight NUMBER is null");
            return null;
        }
        Optional<Flight> flight = flightRepository.findByFlightID(flightID);
        log.info("Recherche d'un vol par son numéro {}", flightID);
        return flight.map(mapper::flightToFlightDTO)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun vol avec le numéro = " + flightID + "n'a été trouvé",
                        ErrorCodes.FLIGHT_NOT_FOUND
                ));
    }

    @Override
    public List<FlightDTO> comparePrice(Integer takeOffCity, Integer landingCity, Date takeOffDate)
    {
        List<Flight> flights = flightRepository.flightPriceComparaison(takeOffCity, landingCity, takeOffDate);
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

    @Override
    public void delete(Integer id)
    {

    }
}
