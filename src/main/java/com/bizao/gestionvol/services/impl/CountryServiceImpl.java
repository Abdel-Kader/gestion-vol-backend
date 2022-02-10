package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.exceptions.ErrorCodes;
import com.bizao.gestionvol.exceptions.InvalideEntityException;
import com.bizao.gestionvol.validators.CountryValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.bizao.gestionvol.dto.CountryDTO;
import com.bizao.gestionvol.entities.Country;
import org.springframework.stereotype.Service;
import com.bizao.gestionvol.mappers.CountryMapper;
import com.bizao.gestionvol.services.CountryService;
import com.bizao.gestionvol.repositories.CountryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CountryServiceImpl implements CountryService
{
    private final CountryRepository counterRepository;
    private final CountryMapper mapper;


    @Override
    public CountryDTO save(CountryDTO dto)
    {
        List<String> errors = CountryValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Country not valid {}", dto);
            throw new InvalideEntityException("L'objet Country n'est pas valide",
                    ErrorCodes.COUNTRY_NOT_VALID, errors);
        }
        Country country = counterRepository.save(mapper.countryDTOtoCountry(dto));
        log.info("Création d'un nouveau pays, {}", country);
        return mapper.countryToCountryDTO(country);
    }

    @Override
    public List<CountryDTO> findAll()
    {
        List<Country> countryList = counterRepository.findAll();
        log.info("Liste des pays {}", countryList);
        return countryList.stream().map(mapper::countryToCountryDTO)
            .collect(Collectors.toList());
    }

}
