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

    @Transient
    private Date duration;

    private String className;

    private double classPrice;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "takeOffCityId")
    private City takeOffCity;

    @ManyToOne
    @JoinColumn(name = "landingCityId")
    private City landingCity;


}
