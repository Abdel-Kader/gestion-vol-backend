package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.dto.CityDTO;
import com.bizao.gestionvol.entities.City;
import com.bizao.gestionvol.exceptions.EntityNotFoundException;
import com.bizao.gestionvol.exceptions.ErrorCodes;
import com.bizao.gestionvol.exceptions.InvalideEntityException;
import com.bizao.gestionvol.mappers.CityMapper;
import com.bizao.gestionvol.repositories.CityRepository;
import com.bizao.gestionvol.services.CityService;
import com.bizao.gestionvol.validators.CityValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CityServiceImpl implements CityService
{
    private final CityRepository cityRepository;
    private final CityMapper mapper;

    @Override
    public CityDTO save(CityDTO dto)
    {
        List<String> errors = CityValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("City not valid {}", dto);
            throw new InvalideEntityException("L'objet City n'est pas valide", ErrorCodes.CITY_NOT_VALID);
        }
        City city = cityRepository.save(mapper.cityDTOtoCity(dto));
        log.info("Création d'une nouvelle ville, {}", city);
        return mapper.cityToCityDTO(city);
    }

    @Override
    public CityDTO findById(Integer id)
    {
        if(id == null) {
            log.error("City ID is null");
            return null;
        }
        Optional<City> city = cityRepository.findById(id);
        log.info("Recherche d'une ville par son ID {}", id);
        return city.map(mapper::cityToCityDTO)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune ville avec l'ID = " + id + "n'a été trouvée",
                        ErrorCodes.CITY_NOT_FOUND
                ));
    }

    @Override
    public List<CityDTO> findAll()
    {
        List<City> cityList = cityRepository.findAll();
        log.info("Liste des villes {}", cityList);
        return cityList.stream().map(mapper::cityToCityDTO)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {

    }
}
