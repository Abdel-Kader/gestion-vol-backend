package com.bizao.gestionvol.repositories;

import com.bizao.gestionvol.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer>
{
}
