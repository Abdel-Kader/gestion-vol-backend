package com.bizao.gestionvol.mappers;

import com.bizao.gestionvol.dto.CompanyDTO;
import com.bizao.gestionvol.entities.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper
{
    CompanyDTO companyToCompanyDTO(Company company);

    Company companyDTOtoCompany(CompanyDTO dto);
}
