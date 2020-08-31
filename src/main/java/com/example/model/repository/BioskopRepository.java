package com.example.model.repository;
import com.example.model.entity.Bioskop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BioskopRepository extends JpaRepository<Bioskop,Long> {


    Bioskop findByNaziv(String naziv);
    List<Bioskop>findAllByMenadzerId(Long id);
    Bioskop findByAdresa(String adresa);


}
