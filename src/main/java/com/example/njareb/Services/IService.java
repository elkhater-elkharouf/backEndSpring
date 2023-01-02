package com.example.njareb.Services;

import com.example.njareb.Entities.Direction;
import com.example.njareb.Entities.Musee;
import com.example.njareb.Entities.OeuvreArt;
import com.example.njareb.Entities.Zone;

import java.util.List;

public interface IService {
    Musee ajouterMusee(Musee musee);
    public Zone ajouterZoneEtAffecterAMusee (Zone zone, Long idMusee);
    OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long idZone);
    void affecterPersonnelsAZone(Long idZone, Long idGardien, Long idDirecteur);
    List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) ;



}
