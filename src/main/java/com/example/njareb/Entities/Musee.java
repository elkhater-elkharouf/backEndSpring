package com.example.njareb.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Musee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMusee; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateInauguration;
    private String designation;
    private String adresse ;

    @OneToMany(mappedBy = "musee" , fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Zone> zones;
}
