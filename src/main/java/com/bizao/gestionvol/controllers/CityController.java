package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.CityAPI;
import com.bizao.gestionvol.dto.CityDTO;
import com.bizao.gestionvol.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CityController implements CityAPI
{
    private final CityService cityService;

    @Override
    public ResponseEntity<CityDTO> saveCity(CityDTO dto)
    {
        CityDTO city = cityService.save(dto);
        return ResponseEntity.ok(city);
    }

    @Override
    public ResponseEntity<List<CityDTO>> findAll()
    {
        List<CityDTO> cityDTOList = cityService.findAll();
        return ResponseEntity.ok(cityDTOList);
    }
}
