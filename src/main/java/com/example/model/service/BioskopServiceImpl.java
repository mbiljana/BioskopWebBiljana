package com.example.model.service;

import com.example.model.entity.dto.DTO.BioskopDTO;
import com.example.model.entity.dto.DTO.SalaDTO;
import com.example.model.entity.Bioskop;
import com.example.model.entity.EnumUloga;
import com.example.model.entity.Sala;
import com.example.model.repository.BioskopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.entity.dto.DTO.KorisnikDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
public class BioskopServiceImpl implements BioskopService{
    @Autowired
    private BioskopRepository bioskopRepository;
    @Autowired
    private SalaService salaService;

    @Override
    public List<Bioskop> findAll() {
        List<Bioskop> bioskopi = this.bioskopRepository.findAll();
        return bioskopi;
    }

    @Override
    public Bioskop findOne(Long id) {
        Bioskop bioskop = this.bioskopRepository.getOne(id);
        return bioskop;
    }


    @Override
    public List<Bioskop> findByMenadzer(Long id) {
        List<Bioskop> bioskopi = this.bioskopRepository.findAllByMenadzerId(id);
        return bioskopi;
    }

    @Override
    public Bioskop findByNaziv(String naziv){
        return bioskopRepository.findByNaziv(naziv);
    }
    @Override
    public Bioskop findByAdresa(String adresa){
        return bioskopRepository.findByAdresa(adresa);
    }

    @Override
    public void delete(Long id){
        bioskopRepository.deleteById(id);
    }

    @Override
    public Bioskop save(Bioskop bioskop){
        return this.bioskopRepository.save(bioskop);
    }







}
