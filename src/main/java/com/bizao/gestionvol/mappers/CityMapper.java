package com.bizao.gestionvol.mappers;

import com.bizao.gestionvol.dto.CityDTO;
import com.bizao.gestionvol.entities.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper
{
    CityDTO cityToCityDTO(City city);

    City cityDTOtoCity(CityDTO dto);
}
