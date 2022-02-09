package com.bizao.gestionvol.services;

import com.bizao.gestionvol.dto.AirportDTO;
import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.dto.FlightDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public interface FlightService extends AbstractService<FlightDTO>
{
    FlightDTO findByFlightID(String flightID);

    List<FlightDTO> comparePrice(Integer takeOffCity, Integer landingCity, Date takeOffDate);

    List<FlightDTO> flightsByCompany(CompanyDTO companyDTO);


}
