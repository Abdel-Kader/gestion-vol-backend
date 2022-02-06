package com.bizao.gestionvol.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable
{
    @Id
    @SequenceGenerator(

            name = "id_sequence",
            sequenceName = "pk_sequence",
            allocationSize = 10
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "pk_sequence")
    private Integer id;

    @Column(name="creationDate", nullable = false)
    private LocalDateTime creationDate;


    @Column(name="lastUpdatedDate")
    private LocalDateTime lastUpdatedDate;

    @PrePersist
    public void init()
    {
        this.creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void updated()
    {
        this.lastUpdatedDate = LocalDateTime.now();
    }
}
