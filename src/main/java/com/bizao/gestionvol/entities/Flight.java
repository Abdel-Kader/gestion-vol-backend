package com.bizao.gestionvol.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Flight extends AbstractEntity
{
    @Column(unique = true)
    private String flightID;

    private Date takeOffDate;

    private Date landingDate;

    private String className;

    private double classPrice;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "takeOffAirportId")
    private Airport takeOffAirport;

    @ManyToOne
    @JoinColumn(name = "landingAirportId")
    private Airport landingAirport;

}
