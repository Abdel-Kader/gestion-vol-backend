package com.bizao.gestionvol.validators;

import com.bizao.gestionvol.dto.CountryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CountryValidator
{
    public static List<String> validate(CountryDTO dto)
    {
        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasLength(dto.getCountryName()))
        {
            errors.add("Veuillez renseigner le nom du pays");
        }
        return errors;
    }
}
