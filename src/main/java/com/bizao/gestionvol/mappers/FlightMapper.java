package com.bizao.gestionvol.mappers;

import com.bizao.gestionvol.dto.FlightDTO;
import com.bizao.gestionvol.entities.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper
{
    FlightDTO flightToFlightDTO(Flight flight);

    Flight flightDTOtoFlight(FlightDTO dto);
}
