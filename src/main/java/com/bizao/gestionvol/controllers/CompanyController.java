package com.bizao.gestionvol.controllers;

import com.bizao.gestionvol.controllers.api.CompanyAPI;
import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://kind-ardinghelli-54180a.netlify.app")
public class CompanyController implements CompanyAPI
{
    private final CompanyService companyService;


    @Override
    public ResponseEntity<CompanyDTO> saveCompany(CompanyDTO dto)
    {
        CompanyDTO company = companyService.save(dto);
        return ResponseEntity.ok(company);
    }

    @Override
    public ResponseEntity<List<CompanyDTO>> findAll()
    {
        List<CompanyDTO> companyDTOList = companyService.findAll();
        return ResponseEntity.ok(companyDTOList);
    }
}
