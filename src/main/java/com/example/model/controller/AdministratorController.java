package com.example.model.controller;

import com.example.model.entity.Korisnik;
import com.example.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdministratorController {

    @Autowired
    private AdministratorServiceImpl administratorService;
    @Autowired
    private BioskopServiceImpl bioskopService;
    @Autowired
    private MenadzerServiceImpl menadzerService;
    @Autowired
    private FilmServiceImpl filmService;
    @Autowired
    private KorisnikServiceImpl korisnikService;

    //aktivacija korisnika
    @GetMapping("/aktiviraj-korisnika/{id}")
    public String aktivacija(@PathVariable(name="id")Long id, Model model){
        Korisnik korisnik=korisnikService.findOne(id);
        //ako je korisnik neaktivan
        if(korisnik.getAktivan()==false){
            korisnik.setAktivan(true);
        }
        korisnikService.save(korisnik);
        model.addAttribute("korisnici",korisnik);
        return "redirect:/korisnici";
    }

    //deaktivacija korisnika
    @GetMapping("/deaktiviraj-korisnika/{id}")
    public String deaktivacija(@PathVariable(name="id")Long id, Model model){
        Korisnik korisnik=korisnikService.findOne(id);
        //ukoliko je korisnik aktivan
        if(korisnik.getAktivan()==true){
            korisnik.setAktivan(false);
        }
        korisnikService.save(korisnik);
        model.addAttribute("korisnik",korisnik);
        return "redirect:/korisnici";
    }




}
