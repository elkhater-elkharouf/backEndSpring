package com.example.njareb.Controller;

import com.example.njareb.Entities.Direction;
import com.example.njareb.Entities.Musee;
import com.example.njareb.Entities.OeuvreArt;
import com.example.njareb.Entities.Zone;
import com.example.njareb.Services.IService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class TestContr {
    IService iService ;
    @PostMapping("/ajouterMusee")
    @ResponseBody
    public Musee ajouterMusee(@RequestBody Musee musee ) {

        return iService.ajouterMusee(musee);
    }
    @PostMapping("/ajouterZoneEtAffecterAMusee/{idMusee}")
    @ResponseBody
    public Zone ajouterZoneEtAffecterAMusee(@RequestBody Zone zone , @PathVariable("idMusee") Long idMusee ) {

        return iService.ajouterZoneEtAffecterAMusee(zone,idMusee);
    }
    @PostMapping("/ajouterOeuvreArtEtAffecterAZone/{idZone}")
    @ResponseBody
    public OeuvreArt ajouterOeuvreArtEtAffecterAZone(@RequestBody OeuvreArt oeuvreArt,@PathVariable("idZone") Long idZone) {

        return iService.ajouterOeuvreArtEtAffecterAZone(oeuvreArt,idZone);
    }
    @PostMapping("/affecterPersonnelsAZone/{idZone}/{idGardien}/{idDirecteur}")
    public void affecterPersonnelsAZone(@PathVariable("idZone") Long idZone, @PathVariable("idGardien") Long idGardien, @PathVariable("idDirecteur") Long idDirecteur) {
        iService.affecterPersonnelsAZone(idZone,idGardien,idDirecteur);
    }
   @GetMapping("titreTableauParMuseeEtDirection/{idMusee}/{direction}")
    public List<String> titreTableauParMuseeEtDirection(@PathVariable("idMusee") Long idMusee, @PathVariable("direction") Direction direction) {
        return iService.titreTableauParMuseeEtDirection(idMusee, direction);
    }
}
