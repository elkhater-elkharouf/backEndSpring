package com.example.njareb.Repo;

import com.example.njareb.Entities.Personnel;
import com.example.njareb.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepo extends JpaRepository<Personnel, Long> {
}
