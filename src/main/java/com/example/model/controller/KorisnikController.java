package com.example.model.controller;

import com.example.model.DTO.KorisnikDTO;
import com.example.model.DTO.PrijavaKorisnikaDTO;
import com.example.model.entity.Korisnik;
import com.example.model.service.KorisnikService;
import com.example.model.service.KorisnikServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/")
    public String welcome() {
        return "home.html";
    }

    //dodavanje
    @PostMapping(value = "/dodajKorisnika",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> dodajKorisnika(@RequestBody KorisnikDTO korisnikDTO){
    KorisnikDTO rezultat= korisnikService.dodajKorisnika(korisnikDTO);
    if(rezultat==null){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }else{
        return new ResponseEntity<>(rezultat,HttpStatus.OK);

    }
    }
    @GetMapping("/dodajKorisnika")
    public String dodajKorisnika(Model model){
        KorisnikDTO korisnik=new KorisnikDTO();
        model.addAttribute("korisnik",korisnik);
    return "registracija.html";
    }

    //prijava
    @PostMapping(value = "/prijavaKorisnika", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> prijavaKorisnika(@RequestBody PrijavaKorisnikaDTO korisnik) {
        KorisnikDTO dto = korisnikService.prijavaKorisnika(korisnik.getKorisnickoIme(), korisnik.getLozinka(), true);
        if(dto == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }
    @GetMapping("/prijavaKorisnika")
    public String prijavaKorisnika(Model model){
        KorisnikDTO korisnik=new KorisnikDTO();
        model.addAttribute("korisnik",korisnik);
        return "prijava.html";
    }


    @GetMapping(value = "/pregledprofila/{korisnickoIme}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<KorisnikDTO> getUser(@PathVariable String korisnickoIme) {
        KorisnikDTO dto = korisnikService.pregledProfila(korisnickoIme);
        if(dto == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(dto, HttpStatus.OK);
    }










}
