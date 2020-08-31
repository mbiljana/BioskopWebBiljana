package com.example.model.service;

import com.example.model.entity.Gledalac;
import com.example.model.repository.GledalacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GledalacServiceImpl implements GledalacService{
    @Autowired
    private GledalacRepository gledalacRepository;

    @Override
    public void dodajGledaoca(Gledalac gledalac){
        gledalacRepository.save(gledalac);
    }

    @Override
    public Gledalac findByKorisnicko_ime(String korisnickoIme){
        return gledalacRepository.findByKorisnickoIme(korisnickoIme);
    }

    @Override
    public Gledalac findByImeAndPrezime(String ime, String prezime){
        return gledalacRepository.findByImeAndPrezime(ime,prezime);
    }

    @Override
    public List<Gledalac> findAll(){
        return gledalacRepository.findAll();
    }


}
