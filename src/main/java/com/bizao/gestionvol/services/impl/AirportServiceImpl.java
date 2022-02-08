package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.dto.AirportDTO;
import com.bizao.gestionvol.entities.Airport;
import com.bizao.gestionvol.exceptions.EntityNotFoundException;
import com.bizao.gestionvol.exceptions.ErrorCodes;
import com.bizao.gestionvol.exceptions.InvalideEntityException;
import com.bizao.gestionvol.mappers.AirportMapper;
import com.bizao.gestionvol.repositories.AirportRepository;
import com.bizao.gestionvol.services.AirportService;
import com.bizao.gestionvol.validators.AirportValidator;
import com.bizao.gestionvol.validators.CityValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AirportServiceImpl implements AirportService
{
    private final AirportRepository airportRepository;
    private final AirportMapper mapper;

    @Override
    public AirportDTO save(AirportDTO dto)
    {
        List<String> errors = AirportValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Airport not valid {}", dto);
            throw new InvalideEntityException("L'objet Airport n'est pas valide", ErrorCodes.AIRPORT_NOT_VALID);
        }
        Airport airport = airportRepository.save(mapper.airportDTOtoAirport(dto));

        log.info("création d'un nouvel aéroport {}", airport);

        return mapper.airportToAirportDTO(airport);
    }

    @Override
    public AirportDTO findById(Integer id)
    {
        if(id == null) {
            log.error("Airport ID is null");
            return null;
        }
        Optional<Airport> airport = airportRepository.findById(id);
        log.info("Recherche d'un aéroport par son ID {}", id);
        return airport.map(mapper::airportToAirportDTO)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucun aéroport avec l'ID = " + id + "n'a été trouvé",
                        ErrorCodes.AIRPORT_NOT_FOUND
                ));
    }

    @Override
    public List<AirportDTO> findAll()
    {
        List<Airport> airportList = airportRepository.findAll();
        log.info("Liste des aéroports {}", airportList);
        return airportList.stream().map(mapper::airportToAirportDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {

    }
}
