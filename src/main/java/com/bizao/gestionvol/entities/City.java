package com.bizao.gestionvol.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class City extends AbstractEntity
{
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;
}
