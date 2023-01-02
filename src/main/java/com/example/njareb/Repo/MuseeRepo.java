package com.example.njareb.Repo;

import com.example.njareb.Entities.Musee;
import com.example.njareb.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseeRepo extends JpaRepository<Musee, Long> {
}
