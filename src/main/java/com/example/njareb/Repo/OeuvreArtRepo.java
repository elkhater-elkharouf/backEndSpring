package com.example.njareb.Repo;

import com.example.njareb.Entities.Direction;
import com.example.njareb.Entities.OeuvreArt;
import com.example.njareb.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OeuvreArtRepo extends JpaRepository<OeuvreArt, Long> {
    List<OeuvreArt> findByZoneMuseeIdMuseeAndZoneDirection(Long idMusee, Direction direction);
}
