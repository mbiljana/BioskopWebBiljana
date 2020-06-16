package com.example.model.repository;
import com.example.model.entity.Bioskop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BioskopRepository extends JpaRepository<Bioskop,Long> {


    Bioskop findByNaziv(String naziv);

}
