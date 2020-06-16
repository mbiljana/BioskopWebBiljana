package com.example.model.controller;


import com.example.model.DTO.BioskopDTO;
import com.example.model.DTO.KorisnikDTO;
import com.example.model.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;


    @PostMapping(value="/dodajBioskop", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BioskopDTO> dodajBioskop(@RequestBody BioskopDTO bioskopDTO){
        BioskopDTO bioskop = bioskopService.dodajBioskop(bioskopDTO);
        if(bioskop==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(bioskop,HttpStatus.OK);
        }
    }

    @GetMapping("/dodajBiosko")
    public String dodajBioskop(Model model){
        BioskopDTO bioskop=new BioskopDTO();
        model.addAttribute("bioskop",bioskop);
        return "dodavanjeBioskopa.html";
    }

}
