package com.example.njareb.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Zone implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long idZone; // Clé primaire
    private String code;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private Direction direction ;
    private boolean actif ;
    @OneToMany(mappedBy = "zone" , fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<OeuvreArt> oeuvreArt;
    @ManyToOne
    @JsonIgnore
    private Musee musee ;

    @OneToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Personnel directeur ;

    @OneToMany(mappedBy = "zones" , fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Personnel> gardiens;



}
