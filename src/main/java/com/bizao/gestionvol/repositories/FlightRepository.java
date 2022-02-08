package com.bizao.gestionvol.repositories;

import com.bizao.gestionvol.entities.Company;
import com.bizao.gestionvol.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer>
{
    Optional<Flight> findByFlightID(String flightID);

    @Query(nativeQuery = true, value = "SELECT * FROM flight f WHERE f.take_off_city_id = :takeOffCity AND f.landing_city_id = :landingCity " +
            "AND f.take_off_date = :takeOffDate ORDER BY f.class_price")
    List<Flight> flightPriceComparaison(@Param("takeOffCity") Integer takeOffCity, @Param("landingCity") Integer landingCity, @Param("takeOffDate") Date takeOffDate);

    List<Flight> findByCompany(Company company);

}
