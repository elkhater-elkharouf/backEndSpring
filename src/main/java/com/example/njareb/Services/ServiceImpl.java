package com.example.njareb.Services;

import com.example.njareb.Entities.*;
import com.example.njareb.Repo.MuseeRepo;
import com.example.njareb.Repo.OeuvreArtRepo;
import com.example.njareb.Repo.PersonnelRepo;
import com.example.njareb.Repo.ZoneRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService{
    MuseeRepo museeRepo ;
    OeuvreArtRepo oeuvreArtRepo ;
    PersonnelRepo personnelRepo ;
    ZoneRepo zoneRepo ;
    @Override
    public Musee ajouterMusee(Musee musee) {
        return museeRepo.save(musee);
    }

    @Override
    public Zone ajouterZoneEtAffecterAMusee(Zone zone, Long idMusee) {
        Musee m =museeRepo.findById(idMusee).orElse(null);
        zone.setMusee(m);
        return zoneRepo.save(zone) ;
    }

    @Override
    public OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long idZone) {
        Zone z =zoneRepo.findById(idZone).orElse(null);
        oeuvreArt.setZone(z);
        return oeuvreArtRepo.save(oeuvreArt);
    }

    @Override
    public void affecterPersonnelsAZone(Long idZone, Long idGardien, Long idDirecteur) {
        Personnel gardien =personnelRepo.findById(idGardien).orElse(null);
        Personnel directeur=personnelRepo.findById(idDirecteur).orElse(null) ;
        Zone zone =zoneRepo.findById(idZone).orElse(null) ;
        zone.setDirecteur(directeur);
        gardien.setZone(zone);
        zoneRepo.save(zone);

    }

    @Override
    public List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) {
        List<String> titres = new ArrayList<>();
        for (OeuvreArt art : oeuvreArtRepo.findByZoneMuseeIdMuseeAndZoneDirection(idMusee, direction)){
            titres.add(art.getTitreTableau());
        }
        return titres;
    }



}
