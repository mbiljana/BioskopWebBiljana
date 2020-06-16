package com.example.model.repository;
import com.example.model.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {
}
