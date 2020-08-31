package com.example.model.service;

import com.example.model.entity.dto.DTO.KorisnikDTO;
import com.example.model.entity.*;
import com.example.model.entity.dto.DTO.PrijavaKorisnikaDTO;
import com.example.model.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService{
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Override
    public Korisnik findByKorisnickoIme(String ime) {
        Korisnik korisnikk = this.korisnikRepository.findByKorisnickoIme( ime);
        return korisnikk;
    }

    @Override
    public List<Korisnik> findAll() {
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }

    @Override
    public Korisnik save(Korisnik korisnik) {
        return this.korisnikRepository.save(korisnik);
    }
    @Override
    public void delete(Long id) {
        korisnikRepository.deleteById(id);
    }

    @Override
    public List<Korisnik> findAllMenadzeri(EnumUloga uloga) {
        List<Korisnik> menadzeri = this.korisnikRepository.findAllByUloga(uloga);
        return menadzeri;
    }

    @Override
    public Korisnik findOne(Long id) {
        Korisnik korisnik=korisnikRepository.getOne(id);
        return korisnik;
    }

    @Override
    public Korisnik loginProvera(PrijavaKorisnikaDTO korisnik){
        Korisnik korisnik1=this.korisnikRepository.findByKorisnickoImeAndLozinka(korisnik.getKorisnickoIme(),korisnik.getLozinka());
    return korisnik1;
    }




}
