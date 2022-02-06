package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.CountryAPI;
import com.bizao.gestionvol.dto.CountryDTO;
import com.bizao.gestionvol.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CountryController implements CountryAPI
{
    private final CountryService countryService;

    @Override
    public CountryDTO saveCountry(CountryDTO dto)
    {
        return countryService.save(dto);
    }

    @Override
    public List<CountryDTO> findAll()
    {
        return countryService.findAll();
    }
}
