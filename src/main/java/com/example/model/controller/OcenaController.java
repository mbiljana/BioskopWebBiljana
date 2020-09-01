package com.example.model.controller;

import com.example.model.entity.Gledalac;
import com.example.model.entity.Ocena;
import com.example.model.entity.dto.DTO.IDOcenaDTO;
import com.example.model.entity.dto.DTO.OcenaDTO;
import com.example.model.entity.dto.DTO.PrijavaKorisnikaDTO;
import com.example.model.service.FilmService;
import com.example.model.service.GledalacService;
import com.example.model.service.KorisnikService;
import com.example.model.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/ocena")
public class OcenaController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FilmService filmService;
   //@Autowired
   // private OcenaService ocenaService;
    @Autowired
    private GledalacService gledalacService;


    //kreiranje ocene
    /*
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<IDOcenaDTO>dodajOcenu(@RequestBody OcenaDTO ocenaDTO){
        Ocena ocena=new Ocena(ocenaDTO.getOcena(),this.filmService.findOne(ocenaDTO.getIdFilma()),this.gledalacService.findByKorisnicko_ime(ocenaDTO.getKorisnickoIme()));
        Ocena novaOcena=this.ocenaService.create(ocena);
        IDOcenaDTO oDTO=new IDOcenaDTO(novaOcena.getFilm().getId(),novaOcena.getGledalac().getId(),novaOcena.getOcena());
        return new ResponseEntity<>(oDTO, HttpStatus.OK);
    }

     */

    //kreiranje liste ocena za datog korisnika
    /*
    @PostMapping(
            value = "/ocenjeni",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<OcenaDTO>>ocenjeni(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO){
        List<Ocena>ocene=this.ocenaService.findAll();
        Gledalac gledalac=this.gledalacService.findByKorisnicko_ime(prijavaKorisnikaDTO.getKorisnickoIme());
        List<OcenaDTO>ocenaDTOList=new ArrayList<>();
        for(Ocena o: ocene){
            if(o.getGledalac().getId()==gledalac.getId()){
                OcenaDTO ocenaDTO=new OcenaDTO(o.getId(),o.getFilm().getId(),
                        o.getGledalac().getId(),o.getGledalac().getKorisnicko_ime(),
                        o.getFilm().getNaziv(),o.getOcena())
                ocenaDTOList.add(ocenaDTO);
            }
        }
        return new ResponseEntity<>(ocenaDTOList,HttpStatus.OK);
    }

     */




}
