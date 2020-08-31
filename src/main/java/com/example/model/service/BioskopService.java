package com.example.model.service;

import com.example.model.entity.dto.DTO.BioskopDTO;
import com.example.model.entity.Bioskop;

import java.util.List;

public interface BioskopService {
    List<Bioskop> findAll();
    Bioskop findOne(Long id);
    List<Bioskop> findByMenadzer(Long id);
    Bioskop findByNaziv(String naziv);
    Bioskop findByAdresa(String adresa);
    void delete(Long id);
    Bioskop save(Bioskop bioskop);
}
