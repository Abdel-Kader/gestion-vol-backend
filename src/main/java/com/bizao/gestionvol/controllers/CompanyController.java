package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.CompanyAPI;
import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompanyController implements CompanyAPI
{
    private final CompanyService companyService;


    @Override
    public CompanyDTO saveCompany(CompanyDTO dto)
    {
        return companyService.save(dto);
    }

    @Override
    public List<CompanyDTO> findAll()
    {
        return companyService.findAll();
    }
}
