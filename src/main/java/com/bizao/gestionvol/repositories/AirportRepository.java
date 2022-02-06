package com.bizao.gestionvol.repositories;

import com.bizao.gestionvol.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer>
{
}
