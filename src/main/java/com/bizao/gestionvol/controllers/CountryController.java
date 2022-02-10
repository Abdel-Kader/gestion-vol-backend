package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.CountryAPI;
import com.bizao.gestionvol.dto.CountryDTO;
import com.bizao.gestionvol.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://kind-ardinghelli-54180a.netlify.app")
public class CountryController implements CountryAPI
{
    private final CountryService countryService;

    @Override
    public ResponseEntity<CountryDTO> saveCountry(CountryDTO dto)
    {
        CountryDTO country = countryService.save(dto);
        return ResponseEntity.ok(country);
    }

    @Override
    public ResponseEntity<List<CountryDTO>> findAll()
    {
        List<CountryDTO> countryDTOList = countryService.findAll();
        return ResponseEntity.ok(countryDTOList);
    }
}
