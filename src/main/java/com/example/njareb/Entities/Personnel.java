package com.example.njareb.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idPersonnel; // Clé primaire
    private String nom;
    private String prenom;
    private Date dateDerniereAffectation ;
    @Enumerated(EnumType.STRING)
    private TypePersonnel typePersonnel ;
    @OneToOne(mappedBy = "directeur", fetch = FetchType.LAZY)
    @JsonIgnore
    private Zone zone ;
    @ManyToOne
    @JsonIgnore
    private Zone zones ;
}
