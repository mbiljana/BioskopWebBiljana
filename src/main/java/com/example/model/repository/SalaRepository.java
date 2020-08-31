package com.example.model.repository;
import com.example.model.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Sala findByOznakaSale(String oznaka);
}
