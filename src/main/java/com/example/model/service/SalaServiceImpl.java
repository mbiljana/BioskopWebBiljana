package com.example.model.service;

import com.example.model.DTO.SalaDTO;
import com.example.model.entity.Bioskop;
import com.example.model.entity.Sala;
import com.example.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class SalaServiceImpl implements SalaService{
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> findAll(){
        return salaRepository.findAll();
    }

    @Override
    public void delete(Sala sala) {
        salaRepository.delete(sala);
    }

    @Override
    public Sala findById(Long id) {
        Sala sala=salaRepository.getOne(id);
        return sala;
    }

    @Override
    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    @Override
    public Sala findByNaziv(String naziv) {
        return salaRepository.findByOznakaSale(naziv);
    }


    @Override
    public Sala findOne(Long id) {
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }






}
