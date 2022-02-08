package com.bizao.gestionvol.validators;

import com.bizao.gestionvol.dto.CityDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CityValidator
{
    public static List<String> validate(CityDTO dto)
    {
        List<String> errors = new ArrayList<>();

        if (dto == null)
        {
            errors.add("Veuillez renseigner le nom de la ville");
            errors.add("Veuillez renseigner le pays de la ville");

            return errors;
        }

        if (!StringUtils.hasLength(dto.getCityName()))
        {
            errors.add("Veuillez renseigner le nom de la ville");
        }
        if (dto.getCountry() == null)
        {
            errors.add("Veuillez renseigner le pays de la ville");
        }

        return errors;
    }
}
