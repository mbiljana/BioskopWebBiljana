package com.example.model.controller;

import com.example.model.entity.dto.DTO.ListaProjekcijaDTO;
import com.example.model.entity.dto.DTO.SalaDTO;
import com.example.model.entity.ListaProjekcija;
import com.example.model.entity.Sala;
import com.example.model.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/sale")
public class SalaController {
    @Autowired
    private SalaService salaService;


    //sve sale
    @GetMapping(
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SalaDTO>>getSale(){
        List<Sala>sale=this.salaService.findAll();
        List<SalaDTO>salaDTOS=new ArrayList<>();
        for(Sala s: sale){
            SalaDTO salaDTO= new SalaDTO(s.getId(),s.getKapacitet(),s.getOznaka_sale());
            salaDTOS.add(salaDTO);
        }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }


    //jedna sala
    @GetMapping(
            value="/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SalaDTO>getSala(@PathVariable(name="id")Long id){
        Sala sala= salaService.findById(id);
        SalaDTO salaDTO= new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznaka_sale());
        return new ResponseEntity<>(salaDTO,HttpStatus.OK);
    }


    //brisanje sale
    @GetMapping(
            value="/obrisi/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SalaDTO>obrisiSalu(@PathVariable(name="id")Long id){
        Sala sala=salaService.findById(id);
        salaService.delete(sala);
        SalaDTO salaDTO=new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznaka_sale());
        return new ResponseEntity<>(salaDTO,HttpStatus.OK);
    }

    @GetMapping(
            value="/listaProjekcija/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>> getListaProjekcija(@PathVariable(name="id")Long id){
        Sala sala=salaService.findById(id);
        List<ListaProjekcija> listaProjekcijas=sala.getTerminska_lista_projekcija();
        List<ListaProjekcijaDTO>listaProjekcijaDTOS=new ArrayList<>();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO = new ListaProjekcijaDTO(lp.getId(),lp.getDan(),
                    lp.getPocetak(),lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),
                    lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }


}
