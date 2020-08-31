package com.example.model.repository;
import com.example.model.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OcenaRepository extends JpaRepository<Ocena, Long> {

}
