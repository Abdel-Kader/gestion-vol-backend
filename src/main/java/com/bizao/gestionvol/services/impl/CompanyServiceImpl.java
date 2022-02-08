package com.bizao.gestionvol.services.impl;

import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.entities.Company;
import com.bizao.gestionvol.exceptions.EntityNotFoundException;
import com.bizao.gestionvol.exceptions.ErrorCodes;
import com.bizao.gestionvol.exceptions.InvalideEntityException;
import com.bizao.gestionvol.mappers.CompanyMapper;
import com.bizao.gestionvol.repositories.CompanyRepository;
import com.bizao.gestionvol.services.CompanyService;
import com.bizao.gestionvol.validators.CompanyValidator;
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
public class CompanyServiceImpl implements CompanyService
{
    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Override
    public CompanyDTO save(CompanyDTO dto)
    {
        List<String> errors = CompanyValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Company not valid {}", dto);
            throw new InvalideEntityException("L'objet Company n'est pas valide", ErrorCodes.COMPANY_NOT_VALID);
        }
        Company company = companyMapper.companyDTOtoCompany(dto);
        Company companyResponse = companyRepository.save(company);
        log.info("création d'une nouvelle compagnie {}", company);
        return companyMapper.companyToCompanyDTO(companyResponse);
    }

    @Override
    public CompanyDTO findById(Integer id)
    {
        if(id == null) {
            log.error("Company ID is null");
            return null;
        }
        Optional<Company> company = companyRepository.findById(id);
        log.info("Recherche d'une compagnie par son ID {}", id);
        return company.map(companyMapper::companyToCompanyDTO)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune compangie avec l'ID = " + id + "n'a été trouvée",
                        ErrorCodes.COMPANY_NOT_FOUND
                ));
    }

    @Override
    public List<CompanyDTO> findAll()
    {
        List<Company> companyList = companyRepository.findAll();
        log.info("Liste des compagnies {}", companyList);
        return companyList.stream().map(companyMapper::companyToCompanyDTO)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id)
    {

    }
}
