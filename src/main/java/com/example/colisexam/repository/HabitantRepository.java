package com.example.colisexam.repository;

import com.example.colisexam.entity.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitantRepository extends JpaRepository<Habitant,Long> {
}
