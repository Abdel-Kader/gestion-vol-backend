package com.bizao.gestionvol.mappers;

import com.bizao.gestionvol.dto.AirportDTO;
import com.bizao.gestionvol.entities.Airport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportMapper
{
    AirportDTO airportToAirportDTO(Airport airport);

    Airport airportDTOtoAirport(AirportDTO dto);
}
