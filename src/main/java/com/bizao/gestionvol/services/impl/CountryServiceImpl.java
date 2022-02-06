package com.bizao.gestionvol.services.impl;

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
import java.util.Optional;
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
        Country country = counterRepository.save(mapper.countryDTOtoCountry(dto));
        log.info("Création d'un nouveau pays, {}", country);
        return mapper.countryToCountryDTO(country);
    }

    @Override
    public CountryDTO findById(Integer id)
    {
        Optional<Country> country = counterRepository.findById(id);
        log.info("Recherche d'un pays par son ID {}", id);
        return country.map(mapper::countryToCountryDTO).orElse(null);
    }

    @Override
    public List<CountryDTO> findAll()
    {
        List<Country> countryList = counterRepository.findAll();
        log.info("Liste des pays {}", countryList);
        return countryList.stream().map(mapper::countryToCountryDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {

    }
}
