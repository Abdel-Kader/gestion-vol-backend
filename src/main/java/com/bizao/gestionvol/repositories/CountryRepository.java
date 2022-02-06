package com.bizao.gestionvol.repositories;

import com.bizao.gestionvol.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>
{
        }
