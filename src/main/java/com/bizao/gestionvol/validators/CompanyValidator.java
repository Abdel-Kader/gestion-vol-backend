package com.bizao.gestionvol.validators;

import com.bizao.gestionvol.dto.CompanyDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompanyValidator
{
    public static List<String> validate(CompanyDTO dto)
    {
        List<String> errors = new ArrayList<>();

        if (!StringUtils.hasLength(dto.getCompanyName()))
        {
            errors.add("Veuillez renseigner le nom de la compagnie");
        }
        return errors;
    }
}
