package com.example.model.controller;

import com.example.model.entity.dto.DTO.ListaProjekcijaDTO;
import com.example.model.entity.Film;
import com.example.model.entity.ListaProjekcija;
import com.example.model.entity.Sala;
import com.example.model.repository.FilmRepository;
import com.example.model.service.FilmService;
import com.example.model.service.ListaProjekcijaService;
import com.example.model.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/listaProjekcija")
public class ListaProjekcijaController {
    @Autowired
    private ListaProjekcijaService listaProjekcijaService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmService filmService;


    //sve projekcije
    @GetMapping(
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>getListeProjekcija(){
        List<ListaProjekcija> listaProjekcijas=this.listaProjekcijaService.findAll();
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO= new ListaProjekcijaDTO(lp.getId(),lp.getDan(),
                    lp.getPocetak(),lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),
                    lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS, HttpStatus.OK);
    }


    //detalji o jednoj projekciji
    @GetMapping(
            value="/detaljiProjekcije/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>getListaProjekcija(@PathVariable(name="id")Long id){
        ListaProjekcija lp=this.listaProjekcijaService.findOne(id);
        ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        return new ResponseEntity<>(listaProjekcijaDTO,HttpStatus.OK);
    }



    //pretraga prema nazivu i zanru
    @GetMapping(
            value="naziv/{naziv}/{zanr}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>pretragaNazivZanr(@PathVariable(name="naziv")String naziv,@PathVariable(name="zanr")String zanr){
        Film film=this.filmService.findAllByNazivAndZanr(naziv,zanr);
        List<ListaProjekcija>listaProjekcijas=this.listaProjekcijaService.findAllByFilmId(film.getId());
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                    lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }


    //pretraga prema nazivu
    @GetMapping(
            value="/naziv/{naziv}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>pretragaNaziv(@PathVariable(name="naziv")String naziv){
        Film film=this.filmService.findByNaziv(naziv);
        List<ListaProjekcija>listaProjekcijas=this.listaProjekcijaService.findAllByFilmId(film.getId());
        List<ListaProjekcijaDTO> listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                    lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }

    //pretraga po pocetku i datumu
    @GetMapping(
            value="/pocetak/{pocetak}/{datum}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>pretragaPocetakDatum(@PathVariable(name="pocetak")String pocetak,@PathVariable(name="datum") Date datum){
        ListaProjekcija lp=this.listaProjekcijaService.findAllByPocetakAndDan(pocetak,datum);
        ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        return new ResponseEntity<>(listaProjekcijaDTO,HttpStatus.OK);
    }


    //pretraga po pocetku
    @GetMapping(
            value="/pocetak/{pocetak}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>pretragaPocetak(@PathVariable(name="pocetak")String pocetak){
        ListaProjekcija lp=this.listaProjekcijaService.findByPocetak(pocetak);
        ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),lp.getCena(),
                lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        return new ResponseEntity<>(listaProjekcijaDTO,HttpStatus.OK);
    }


    //liste projkecija u sali
    @GetMapping(
            value="/sveLPuSali/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>getLPSala(@PathVariable(name="id")Long id){
        Sala sala= this.salaService.findById(id);
        List<ListaProjekcija>listaProjekcijas=sala.getTerminska_lista_projekcija();
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),lp.getCena(),
                    lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }


    //kreiranje terminske liste projekcija
    @PostMapping(
            value="/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>kreirajListuProjekcija(@RequestBody ListaProjekcijaDTO listaProjekcijaDTO,@PathVariable(name="id")Long id){
        Film film=new Film(listaProjekcijaDTO.getNazivFilma(),listaProjekcijaDTO.getOpisFilma(),listaProjekcijaDTO.getZanrFilma(),
                listaProjekcijaDTO.getTrajanjeFilma(),listaProjekcijaDTO.getOcena());
        filmRepository.save(film);
        Sala sala=this.salaService.findById(id);
        ListaProjekcija lp = new ListaProjekcija(listaProjekcijaDTO.getNazivFilma(),listaProjekcijaDTO.getZanrFilma(),
                listaProjekcijaDTO.getPocetak(),listaProjekcijaDTO.getDanProjekcije(),listaProjekcijaDTO.getCena(),
                sala,film);
        sala.getTerminska_lista_projekcija().add(lp);
        salaService.save(sala);
        ListaProjekcijaDTO lpDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),lp.getCena(),
                lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        return new ResponseEntity<>(lpDTO,HttpStatus.OK);
    }


    //izmena liste
    @PostMapping(
            value="/izmeni/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>izmeniListuProjekcija(@PathVariable(name="id")Long id,@RequestBody ListaProjekcijaDTO listaProjekcijaDTO){
        ListaProjekcija lp=this.listaProjekcijaService.findOne(id);
        lp.setCena(listaProjekcijaDTO.getCena());
        lp.setDan(listaProjekcijaDTO.getDanProjekcije());
        lp.setPocetak(listaProjekcijaDTO.getPocetak());
        Film film=lp.getFilm();
        film.setOpis(listaProjekcijaDTO.getOpisFilma());
        film.setNaziv(listaProjekcijaDTO.getNazivFilma());
        film.setZanr(listaProjekcijaDTO.getZanrFilma());
        film.setTrajanje(listaProjekcijaDTO.getTrajanjeFilma());
        filmRepository.save(film);
        lp.setFilm(film);
        listaProjekcijaService.save(lp);
        ListaProjekcijaDTO lpDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        return new ResponseEntity<>(lpDTO,HttpStatus.OK);
    }


    //rezervacija karte
    @PostMapping(
            value="/rezervacijaKarte/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ListaProjekcijaDTO>rezervisiKartu(@PathVariable(name="id")Long id){
        ListaProjekcija lp=this.listaProjekcijaService.findOne(id);
        ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
        if(listaProjekcijaDTO.getBrojRezervisanih() < listaProjekcijaDTO.getKapacitetSale()){
            return new ResponseEntity<>(listaProjekcijaDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(listaProjekcijaDTO,HttpStatus.FORBIDDEN);
    }



    //sortiranje po ceni rastuce
    @GetMapping(
            value="/sortCena",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>sortCena(){
        List<ListaProjekcija>listaProjekcijas=this.listaProjekcijaService.sortCena() ;
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                    lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);

    }

    //pretraga
    @PostMapping(
            value="/pretraga",
            produces=MediaType.APPLICATION_JSON_VALUE,
            consumes=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>pretraga(@RequestBody ListaProjekcijaDTO listaProjekcijaDTO){
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        Film film=filmService.findByNaziv(listaProjekcijaDTO.getNazivFilma());
        List<ListaProjekcija>listaProjekcijas=listaProjekcijaService.pretraga(listaProjekcijaDTO.getPocetak(),
                listaProjekcijaDTO.getCena(),listaProjekcijaDTO.getDanProjekcije(),film);
        for(ListaProjekcija lp:listaProjekcijas){
            ListaProjekcijaDTO lpDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                    lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(lpDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);

    }


}
