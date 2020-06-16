package com.example.model.service;

import com.example.model.DTO.KorisnikDTO;
import com.example.model.entity.*;
import com.example.model.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Date;

@Service
public class KorisnikServiceImpl implements KorisnikService{
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Override
    public KorisnikDTO dodajKorisnika(KorisnikDTO dto) {
        //provera da li vec prostojji korisnik sa tim korisnickim imenom
        Korisnik pronadjenKorisnik= korisnikRepository.findByKorisnickoIme(dto.getKorisnicko_ime());
        if (pronadjenKorisnik!= null){
            return null;
        }
        if(dto.getUloga()== EnumUloga.GLEDALAC){
            Gledalac gledalac = new Gledalac(dto.getKorisnicko_ime(), dto.getLozinka(),dto.getIme(),
                    dto.getPrezime(),
                    dto.getKontakt_telefon(), dto.getE_mail(), dto.getDatum_rodjenja(),
                     dto.getUloga(),
                    true);
            korisnikRepository.save(gledalac);
        }else if(dto.getUloga()==EnumUloga.MENADZER){
            Menadzer menadzer = new Menadzer(dto.getKorisnicko_ime(), dto.getLozinka(), dto.getIme(), dto.getPrezime(),
                    dto.getKontakt_telefon(), dto.getKontakt_telefon(), dto.getDatum_rodjenja(), dto.getUloga(),
                    false);
            korisnikRepository.save(menadzer);
        }
        return dto;



    }

    @Override
    public KorisnikDTO prijavaKorisnika(String korisnickoIme, String lozinka, boolean aktivan){

        Korisnik postojiKorisnik=korisnikRepository.findByKorisnickoImeAndLozinkaAndAktivan(korisnickoIme,lozinka,aktivan);
        if(postojiKorisnik==null){
            return null;
        }

        KorisnikDTO korisnik=new KorisnikDTO(postojiKorisnik.getKorisnicko_ime(),postojiKorisnik.getLozinka(),
                                             postojiKorisnik.getIme(),
                                             postojiKorisnik.getPrezime(),postojiKorisnik.getKontakt_telefon(),
                                             postojiKorisnik.getE_mail(),postojiKorisnik.getDatum_rodjenja(),
                                             postojiKorisnik.getUloga());

        return korisnik;
    }

    public KorisnikDTO pregledProfila(String korisnickoIme){
        Korisnik postojiKorisnik=korisnikRepository.findByKorisnickoIme(korisnickoIme);
        if(postojiKorisnik==null){
            return null;
        }

        KorisnikDTO korisnik=new KorisnikDTO(postojiKorisnik.getKorisnicko_ime(),postojiKorisnik.getLozinka(),
                postojiKorisnik.getIme(),
                postojiKorisnik.getPrezime(),postojiKorisnik.getKontakt_telefon(),
                postojiKorisnik.getE_mail(),postojiKorisnik.getDatum_rodjenja(),
                postojiKorisnik.getUloga());

        return korisnik;
    }


}
