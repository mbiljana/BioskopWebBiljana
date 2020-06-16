package com.example.model.service;

import com.example.model.DTO.SalaDTO;
import com.example.model.entity.Sala;
import com.example.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class SalaServiceImpl implements SalaService{
    @Autowired
    private SalaRepository salaRepository;
    @Override
    public HashSet<Sala> dodajSalu(ArrayList<SalaDTO >salaDTOS){
        HashSet<Sala> sale = new HashSet<>();
        for(SalaDTO s: salaDTOS){
            Sala sala=new Sala(s.getKapacitet(),s.getOznaka_sale());
            sala=salaRepository.save(sala);
            sale.add(sala);
        }
        return sale;
    }
}
