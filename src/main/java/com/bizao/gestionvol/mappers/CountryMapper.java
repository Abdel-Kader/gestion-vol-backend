package com.bizao.gestionvol.mappers;

import com.bizao.gestionvol.dto.CountryDTO;
import com.bizao.gestionvol.entities.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper
{
    CountryDTO countryToCountryDTO(Country country);

    Country countryDTOtoCountry(CountryDTO dto);

}
