package com.example.model.controller;


import com.example.model.entity.Gledalac;
import com.example.model.entity.dto.DTO.FilmDTO;
import com.example.model.entity.dto.DTO.ListaProjekcijaDTO;
import com.example.model.entity.Film;
import com.example.model.entity.ListaProjekcija;
import com.example.model.entity.dto.DTO.PrijavaKorisnikaDTO;
import com.example.model.service.FilmService;
import com.example.model.service.KorisnikService;
import com.example.model.service.ListaProjekcijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/filmovi")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private ListaProjekcijaService listaProjekcijaService;
    @Autowired
    private KorisnikService korisnikService;

    //svi filmovi
    @GetMapping(
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FilmDTO>>getFilmovi(){
        List<Film>filmovi=filmService.findAll();
        List<FilmDTO>filmDTOS=new ArrayList<>();
        for(Film f: filmovi){
            FilmDTO filmDTO=new FilmDTO(f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS, HttpStatus.OK);
    }

    //jedan film
    @GetMapping(
            value="/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FilmDTO>getFilm(@PathVariable(name="id")Long id){
        Film film= filmService.findOne(id);
        FilmDTO filmDTO=new FilmDTO(film.getId(),film.getNaziv(),film.getOpis(),film.getZanr(),film.getTrajanje(),film.getOcena());
        return new ResponseEntity<>(filmDTO,HttpStatus.OK);
    }


    //dobavljanje filma po nazivu
    @GetMapping(
            value="/naziv/{naziv}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<FilmDTO>getFilmByNaziv(@PathVariable(name="naziv")String naziv){
        Film film=filmService.findByNaziv(naziv);
        FilmDTO filmDTO= new FilmDTO(film.getId(),film.getNaziv(),film.getOpis(),film.getZanr(),
                film.getTrajanje(),film.getOcena());
        return new ResponseEntity<>(filmDTO,HttpStatus.OK);
    }

    //dobavljanje filma po zanru
    @GetMapping(
            value="/zanr/{zanr}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<FilmDTO>>getFilmByZanr(@PathVariable(name="zanr")String zanr){
        List<Film> filmovi= filmService.findAllByZanr(zanr);
        List<FilmDTO> filmDTOS=new ArrayList<>();
        for(Film f: filmovi){
            FilmDTO filmDTO=new FilmDTO(f.getId(),f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS,HttpStatus.OK);
    }


    //dobavljanje filma po oceni
    @GetMapping(
            value="/ocena/{ocena}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<List<FilmDTO>>getFilmByOcena(@PathVariable(name="ocena")Double ocena){
        List<Film>filmList=filmService.findAllByOcena(ocena);
        List<FilmDTO>filmDTOS=new ArrayList<>();
        for(Film f: filmList){
            FilmDTO filmDTO=new FilmDTO(f.getId(),f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS,HttpStatus.OK);
    }


    //dobavljanje terminske liste projekcija
    @GetMapping(
            value="/listaProjekcija/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>getListaProjekcija(@PathVariable(name="id")Long id){
        Film film=filmService.findOne(id);
        List<ListaProjekcijaDTO> listaProjekcijaDTOS=new ArrayList<>();
        List<ListaProjekcija>listaProjekcijas=listaProjekcijaService.findAllByFilmId(id);
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO= new ListaProjekcijaDTO(lp.getId(),lp.getDan(),
                    lp.getPocetak(),lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),
                    lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }


    //sortiranje po nazivu
    @GetMapping(
            value="/sortNaziv",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FilmDTO>>sortNaziv(){
        List<Film>filmovi=filmService.sortNaziv();
        List<FilmDTO>filmDTOS=new ArrayList<>();
        for(Film f: filmovi){
            FilmDTO filmDTO=new FilmDTO(f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),
                    f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS,HttpStatus.OK);
    }

    //sort po zanru
    @GetMapping(
            value="/sortZanr",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FilmDTO>>sortZanr(){
        List<Film>filmovi=filmService.sortZanr();
        List<FilmDTO>filmDTOS=new ArrayList<>();
        for(Film f: filmovi){
            FilmDTO filmDTO=new FilmDTO(f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),
                    f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS,HttpStatus.OK);
    }

    //sort po oceni
    @GetMapping(
            value="/sortOcena",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FilmDTO>>sortOcena(){
        List<Film>filmovi=filmService.sortOcena();
        List<FilmDTO>filmDTOS=new ArrayList<>();
        for(Film f: filmovi){
            FilmDTO filmDTO=new FilmDTO(f.getNaziv(),f.getOpis(),f.getZanr(),f.getTrajanje(),
                    f.getOcena());
            filmDTOS.add(filmDTO);
        }
        return new ResponseEntity<>(filmDTOS,HttpStatus.OK);
    }


    @PostMapping(
            value="/odgledani",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Film>>getFilmoviKorisnik(@RequestBody PrijavaKorisnikaDTO prijavaKorisnikaDTO){
        List<Film>filmovi=new ArrayList<>();

        for(Film f: this.korisnikService.findByKorisnickoIme(prijavaKorisnikaDTO.getKorisnickoIme()).getOdgledaniFilmovi()){
            filmovi.add(f);
        }
        return new ResponseEntity<>(filmovi,HttpStatus.OK);
    }








}
