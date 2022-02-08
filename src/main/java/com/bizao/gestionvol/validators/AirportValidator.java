package com.bizao.gestionvol.validators;

import com.bizao.gestionvol.dto.AirportDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AirportValidator
{
    public static List<String> validate(AirportDTO dto)
    {
        List<String> errors = new ArrayList<>();

        if (dto == null)
        {
            errors.add("Veuillez renseigner le nom de l'aéroport");
            errors.add("Veuillez renseigner la ville de l'aéroport");

            return errors;
        }

        if (!StringUtils.hasLength(dto.getAirportName()))
        {
            errors.add("Veuillez renseigner le nom de l'aéroport");
        }
        if (dto.getCity() == null)
        {
            errors.add("Veuillez renseigner la ville de l'aéroport");
        }

        return errors;
    }
}
