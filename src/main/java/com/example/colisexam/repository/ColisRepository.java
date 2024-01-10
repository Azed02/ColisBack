package com.example.colisexam.repository;

import com.example.colisexam.entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColisRepository extends JpaRepository<Colis,Long> {
}
