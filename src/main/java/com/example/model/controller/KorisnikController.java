package com.example.model.controller;

import com.example.model.entity.dto.DTO.*;
import com.example.model.entity.*;
import com.example.model.entity.dto.DTO.KorisnikDTO;
import com.example.model.entity.dto.DTO.PrijavaKorisnikaDTO;
import com.example.model.repository.FilmRepository;
import com.example.model.repository.GledalacRepository;
import com.example.model.repository.MenadzerRepository;
import com.example.model.repository.OcenaRepository;
import com.example.model.service.*;

import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private ListaProjekcijaService listaProjekcijaService;
    @Autowired
    private GledalacService gledalacService;
    @Autowired
    private GledalacRepository gledalacRepository;
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private OcenaRepository ocenaRepository;

    //prikaz svih korisnika
    @GetMapping(
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<KorisnikDTO>> getKorisnici(){
        List<Korisnik> korisnikList=this.korisnikService.findAll();
        List<KorisnikDTO> korisnikDTOS=new ArrayList<>();
        for(Korisnik k: korisnikList){
            KorisnikDTO korisnikDTO=new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getKorisnicko_ime(),k.getLozinka(),
            k.getKontakt_telefon(),k.getE_mail(),k.getDatum_rodjenja(),k.getUloga(),k.getAktivan());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS,HttpStatus.OK);
    }

    //prikaz jednog korisnika
    @GetMapping(
            value="/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO>getKorisnik(@PathVariable(name = "id") Long id){
        Korisnik korisnik=this.korisnikService.findOne(id);
        KorisnikDTO korisnikDTO=new KorisnikDTO();
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setKorisnickoIme(korisnik.getKorisnicko_ime());
        korisnikDTO.setDatumRodjenja(korisnik.getDatum_rodjenja());
        korisnikDTO.setEmail(korisnik.getE_mail());
        korisnikDTO.setLozinka(korisnik.getLozinka());
        korisnikDTO.setUloga(korisnik.getUloga());
        korisnikDTO.setAktivan(korisnik.getAktivan());
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    //kreiranje novog korisnika
    @PostMapping(
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO>kreirajKorisnika(@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik postojeciKorisnik = this.korisnikService.findByKorisnickoIme(korisnikDTO.getKorisnickoIme());
        //korisnik vec postoji
        if(postojeciKorisnik != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //u drugom slucaju
        Korisnik korisnik=new Korisnik(korisnikDTO.getKorisnickoIme(),korisnikDTO.getLozinka(),korisnikDTO.getIme(),
                korisnikDTO.getPrezime(),korisnikDTO.getKontaktTelefon(),korisnikDTO.getEmail(),korisnikDTO.getDatumRodjenja(),
                korisnikDTO.getUloga(),korisnikDTO.isAktivan());
        //ako je menadzer
        if(korisnik.getUloga()== EnumUloga.MENADZER){
            Menadzer menadzer=new Menadzer(korisnikDTO.getKorisnickoIme(),korisnikDTO.getLozinka(),korisnikDTO.getIme(),
                    korisnikDTO.getPrezime(),korisnikDTO.getKontaktTelefon(),korisnikDTO.getEmail(),korisnikDTO.getDatumRodjenja(),
                    korisnikDTO.getUloga(),true);
            menadzer.setAktivan(false);
            menadzerRepository.save(menadzer);
            KorisnikDTO korisnikDTO1= new KorisnikDTO(menadzer.getId(),menadzer.getIme(),menadzer.getPrezime(),
                    menadzer.getKorisnicko_ime(),menadzer.getLozinka(),menadzer.getKontakt_telefon(),menadzer.getE_mail(),
                    menadzer.getDatum_rodjenja(),menadzer.getUloga(),menadzer.getAktivan());
            return new ResponseEntity<>(korisnikDTO1,HttpStatus.OK);
        }
        if(korisnik.getUloga()==EnumUloga.GLEDALAC){
            korisnik.setAktivan(true);
            Gledalac gledalac= new Gledalac(korisnikDTO.getKorisnickoIme(),korisnikDTO.getLozinka(),korisnikDTO.getIme(),
                    korisnikDTO.getPrezime(),korisnikDTO.getKontaktTelefon(),korisnikDTO.getEmail(),korisnikDTO.getDatumRodjenja(),
                    korisnikDTO.getUloga(),true);
            gledalacRepository.save(gledalac);
            KorisnikDTO korisnikDTO1=new KorisnikDTO(gledalac.getId(),gledalac.getIme(),gledalac.getPrezime(),
                    gledalac.getKorisnicko_ime(),gledalac.getLozinka(),gledalac.getKontakt_telefon(),gledalac.getE_mail(),
                    gledalac.getDatum_rodjenja(),gledalac.getUloga(),gledalac.getAktivan());
            return new ResponseEntity<>(korisnikDTO1,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //deaktivacija
    @GetMapping(
            value="/deaktiviraj/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> deaktiviraj(@PathVariable (name="id")Long id){
        Korisnik korisnik=this.korisnikService.findOne(id);
        if(korisnik.getAktivan()==true){
            korisnik.setAktivan(false);
        }
        Korisnik korisnik1=korisnikService.save(korisnik);
        KorisnikDTO korisnikDTO= new KorisnikDTO(korisnik1.getId(),korisnik1.getIme(),korisnik1.getPrezime(),
                korisnik1.getKorisnicko_ime(),korisnik1.getLozinka(),korisnik1.getKontakt_telefon(),korisnik1.getE_mail(),
                korisnik1.getDatum_rodjenja(),korisnik1.getUloga(),korisnik1.getAktivan());
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    //aktivacija
    @GetMapping(
            value="/aktiviraj/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> aktiviraj(@PathVariable (name="id")Long id){
        Korisnik korisnik=this.korisnikService.findOne(id);
        if(korisnik.getAktivan()==false){
            korisnik.setAktivan(true);
        }
        Korisnik korisnik1=korisnikService.save(korisnik);
        KorisnikDTO korisnikDTO= new KorisnikDTO(korisnik1.getId(),korisnik1.getIme(),korisnik1.getPrezime(),
                korisnik1.getKorisnicko_ime(),korisnik1.getLozinka(),korisnik1.getKontakt_telefon(),korisnik1.getE_mail(),
                korisnik1.getDatum_rodjenja(),korisnik1.getUloga(),korisnik1.getAktivan());
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    //brisanje korisnika
    @GetMapping(
            value="/obrisi/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO> obrisiKorisnika(@PathVariable(name="id") Long id){
        Korisnik korisnik=this.korisnikService.findOne(id);
        korisnikService.delete(id);
        KorisnikDTO korisnikDTO=new KorisnikDTO(korisnik.getId(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getKorisnicko_ime(),
                korisnik.getLozinka(),korisnik.getKontakt_telefon(),korisnik.getE_mail(),korisnik.getDatum_rodjenja(),
                korisnik.getUloga(),korisnik.getAktivan());
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }

    //bioskopi
    @GetMapping(
            value="/bioskopi/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<BioskopDTO>> getBioskopi(@PathVariable(name="id")Long id){
        Korisnik korisnik=korisnikService.findOne(id);
        List<BioskopDTO> bioskopDTOS=new ArrayList<>();
        Menadzer menadzer=new Menadzer();
        menadzer.setId(korisnik.getId());
        List<Bioskop>bioskopi =menadzer.getBioskopi();
        for(Bioskop b:bioskopi){
            BioskopDTO bioskopDTO= new BioskopDTO(b.getId(),b.getNaziv(),b.getAdresa(),b.getBrojTelefonaCentrale(),
                    b.getE_mail());
            bioskopDTOS.add(bioskopDTO);
        }
        return new ResponseEntity<>(bioskopDTOS,HttpStatus.OK);
    }

    //prikaz trenutno ulogovanog korisnika
    //@GetMapping(value="/trenutni",
     //       produces=MediaType.APPLICATION_JSON_VALUE
   // )


    //menadzeri
    @GetMapping(
            value="/menadzeri",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<KorisnikDTO>>getMenadzeri(){
        List<Korisnik> korisnikList= this.korisnikService.findAllMenadzeri(EnumUloga.MENADZER);
        List<KorisnikDTO> korisnikDTOS= new ArrayList<>();
        for(Korisnik k: korisnikList){
            KorisnikDTO korisnikDTO = new KorisnikDTO(k.getId(),k.getIme(),k.getPrezime(),k.getKorisnicko_ime(),k.getLozinka(),
                    k.getKontakt_telefon(),k.getE_mail(),k.getDatum_rodjenja(),k.getUloga(),k.getAktivan());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS,HttpStatus.OK);
    }


    //gledaoci
    @GetMapping(
            value="/gledaoci",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<KorisnikDTO>>getGledaoci() {
        List<Korisnik> korisnikList = this.korisnikService.findAllMenadzeri(EnumUloga.GLEDALAC);
        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();
        for (Korisnik k : korisnikList) {
            KorisnikDTO korisnikDTO = new KorisnikDTO(k.getId(), k.getIme(), k.getPrezime(), k.getKorisnicko_ime(), k.getLozinka(),
                    k.getKontakt_telefon(), k.getE_mail(), k.getDatum_rodjenja(), k.getUloga(), k.getAktivan());
            korisnikDTOS.add(korisnikDTO);
        }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }


    @PostMapping(
            value="/login",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<KorisnikDTO>login(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO)throws Exception{
        Korisnik korisnik=this.korisnikService.loginProvera(prijavaKorisnikaDTO);
        if(korisnik==null){
            throw new Exception("Greska");
        }
        if(korisnik.getAktivan()==false){
            throw new Exception("Korisnik nije aktivan"); //korisnik mora da bude aktivan
        }
        KorisnikDTO korisnikDTO= new KorisnikDTO(korisnik.getId(),korisnik.getIme(),
                korisnik.getPrezime(),korisnik.getKorisnicko_ime(),korisnik.getLozinka(),korisnik.getKontakt_telefon(),
                korisnik.getE_mail(),korisnik.getDatum_rodjenja(),korisnik.getUloga(),true);
        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }























}
