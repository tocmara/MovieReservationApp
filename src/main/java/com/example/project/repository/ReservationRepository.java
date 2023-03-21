package com.example.project.repository;

import com.example.project.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository  extends JpaRepository<ReservationModel, Integer> {
}
