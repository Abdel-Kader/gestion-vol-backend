package com.bizao.gestionvol.validators;

import com.bizao.gestionvol.dto.FlightDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FlightValidator
{
    public static List<String> validate(FlightDTO dto)
    {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le numéro du vol");
            errors.add("Veuillez renseigner la date de départ");
            errors.add("Veuillez renseigner la date d'arrivée");
            errors.add("Veuillez renseigner une ville de départ");
            errors.add("Veuillez renseigner une ville d'arrivé");
            errors.add("Veuillez sélectionner une compagnie aérienne");
            errors.add("Veuillez sélectionner le prix du vol");
            errors.add("Veuillez sélectionner la classe du vol");

            return errors;
        }
        if (!StringUtils.hasLength(dto.getFlightID()))
        {
            errors.add("Veuillez renseigner le numéro du vol");
        }
        if (dto.getTakeOffDate() == null)
        {
            errors.add("Veuillez renseigner la date de départ");
        }
        if (dto.getLandingDate() == null)
        {
            errors.add("Veuillez renseigner la date d'arrivée");
        }

        if (dto.getTakeOffCity() == null)
        {
            errors.add("Veuillez renseigner une ville de départ");
        }

        if (dto.getLandingCity() == null)
        {
            errors.add("Veuillez renseigner une ville d'arrivée");
        }

        if (dto.getCompany() == null)
        {
            errors.add("Veuillez renseigner une compagnie aérienne");
        }

        if (!StringUtils.hasLength(dto.getClassName()))
        {
            errors.add("Veuillez renseigner la classe");
        }

        if (dto.getClassPrice() == 0)
        {
            errors.add("Veuillez renseigner le prix du vol");
        }

        return errors;
    }
}
