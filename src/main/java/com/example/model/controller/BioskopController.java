package com.example.model.controller;


import com.example.model.entity.dto.DTO.*;
import com.example.model.entity.Bioskop;
import com.example.model.entity.ListaProjekcija;
import com.example.model.entity.Menadzer;
import com.example.model.entity.Sala;
import com.example.model.service.BioskopService;
import com.example.model.service.KorisnikService;
import com.example.model.service.MenadzerService;
import com.example.model.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/bioskopi")
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private MenadzerService menadzerService;
    @Autowired
    private SalaService salaService;

    //svi bioskopi
    @GetMapping(
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<BioskopDTO>>getBioskopi(){
        List<Bioskop> bioskopList=bioskopService.findAll();
        List<BioskopDTO> bioskopDTOS= new ArrayList<>();
        for(Bioskop b: bioskopList){
            BioskopDTO bioskopDTO= new BioskopDTO(b.getId(),b.getNaziv(),b.getAdresa(),b.getBrojTelefonaCentrale(),
                    b.getE_mail());
            bioskopDTOS.add(bioskopDTO);
        }
        return new ResponseEntity<>(bioskopDTOS,HttpStatus.OK);
    }

    //jedan bioskop
    @GetMapping(
            value="/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DodavanjeBioskopaDTO>jedanBioskop(@PathVariable(name="id")Long id){
        Bioskop bioskop=this.bioskopService.findOne(id);
        DodavanjeBioskopaDTO dodavanjeBioskopaDTO= new DodavanjeBioskopaDTO(bioskop.getNaziv(),bioskop.getAdresa(),
                bioskop.getBrojTelefonaCentrale(),bioskop.geteMail(),bioskop.getMenadzer().getId());
        return new ResponseEntity<>(dodavanjeBioskopaDTO,HttpStatus.OK);
    }

    @GetMapping(
            value="/sala/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<DodavanjeSaleDTO>jednaSala(@PathVariable(name="id")Long id){
        Sala sala=salaService.findById(id);
        DodavanjeSaleDTO dodavanjeSaleDTO= new DodavanjeSaleDTO(sala.getOznaka_sale(),sala.getKapacitet());
        return new ResponseEntity<>(dodavanjeSaleDTO,HttpStatus.OK);
    }


    @PostMapping(
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BioskopDTO>createKorisnik(@RequestBody DodavanjeBioskopaDTO dodavanjeBioskopaDTO) throws Exception{
        Menadzer menadzer= menadzerService.findOne(dodavanjeBioskopaDTO.getIdMenadzera());
        Bioskop bioskop=new Bioskop(dodavanjeBioskopaDTO.getNaziv(),dodavanjeBioskopaDTO.getAdresa(),
                dodavanjeBioskopaDTO.getBrojTelefona(),dodavanjeBioskopaDTO.getEmail(),menadzer);
        Bioskop bioskop1=bioskopService.save(bioskop);
        BioskopDTO bioskopDTO= new BioskopDTO(bioskop1.getId(),bioskop1.getNaziv(),bioskop1.getAdresa(),
                bioskop1.getBrojTelefonaCentrale(),bioskop1.getE_mail());
        return new ResponseEntity<>(bioskopDTO, HttpStatus.OK);
    }


    //bioskop izmene
    @PostMapping(
            value="/izmene/{id}",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BioskopDTO> izmeniBioskop(@RequestBody DodavanjeBioskopaDTO dodavanjeBioskopaDTO ,@PathVariable(name="id")Long id){
        Bioskop bioskop=bioskopService.findOne(id);
        bioskop.setNaziv(dodavanjeBioskopaDTO.getNaziv());
        bioskop.setAdresa(dodavanjeBioskopaDTO.getAdresa());
        bioskop.setBroj_telefona_centrale(dodavanjeBioskopaDTO.getBrojTelefona());
        bioskop.setE_mail(dodavanjeBioskopaDTO.getEmail());
        Menadzer menadzer=menadzerService.findOne(dodavanjeBioskopaDTO.getIdMenadzera());
        bioskop.setMenadzer(menadzer);

        bioskopService.save(bioskop);
        BioskopDTO bioskopDTO=new BioskopDTO(bioskop.getId(),bioskop.getNaziv(),bioskop.getAdresa(),
                bioskop.getBrojTelefonaCentrale(),bioskop.getE_mail());
        return new ResponseEntity<>(bioskopDTO,HttpStatus.OK);
    }

    //sale izmene
    @PostMapping(
            value="/izmeneSale/{id}",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SalaDTO>izmeniSalu(@RequestBody DodavanjeSaleDTO dodavanjeSaleDTO,@PathVariable(name="id")Long id){
        Sala sala=salaService.findById(id);
        sala.setOznaka_sale(dodavanjeSaleDTO.getOznakaSale());
        sala.setKapacitet(dodavanjeSaleDTO.getKapacitet());
        salaService.save(sala);
        SalaDTO salaDTO=new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznaka_sale());
        return new ResponseEntity<>(salaDTO,HttpStatus.OK);
    }

    //brisanje
    @GetMapping(
            value="/obrisi/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BioskopDTO>obrisiBioskop(@PathVariable(name="id") Long id){
        Bioskop bioskop=bioskopService.findOne(id);
        bioskopService.delete(id);
        BioskopDTO bioskopDTO = new BioskopDTO(bioskop.getId(),bioskop.getNaziv(),bioskop.getAdresa(),bioskop.getBrojTelefonaCentrale(),
                bioskop.getE_mail());
        return new ResponseEntity<>(bioskopDTO,HttpStatus.OK);
    }

    @GetMapping(
            value="/sale/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<SalaDTO>>getSale(@PathVariable(name="id") Long id){
        Bioskop bioskop=bioskopService.findOne(id);
        List<SalaDTO>salaDTOS=new ArrayList<>();
        List<Sala>sale=bioskop.getSale();
        for(Sala s: sale){
            if(s.getBioskop().getId()==id){
                SalaDTO salaDTO=new SalaDTO(s.getId(),s.getKapacitet(),s.getOznaka_sale());
                salaDTOS.add(salaDTO);
            }
        }
        return new ResponseEntity<>(salaDTOS,HttpStatus.OK);
    }


    @PostMapping(
            value="/dodajSalu/{id}",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SalaDTO> dodajSalu(@RequestBody DodavanjeSaleDTO dodavanjeSaleDTO,@PathVariable(name="id") Long id){
        Bioskop bioskop=bioskopService.findOne(id);
        Sala sala=new Sala(dodavanjeSaleDTO.getKapacitet(),dodavanjeSaleDTO.getOznakaSale(),bioskop);
        salaService.save(sala);
        bioskop.getSale().add(sala);
        bioskopService.save(bioskop);
        SalaDTO salaDTO=new SalaDTO(sala.getId(),sala.getKapacitet(),sala.getOznaka_sale());
        return new ResponseEntity<>(salaDTO,HttpStatus.OK);
    }

    @GetMapping(
            value="/sale/terminskaLista/{id}",
            produces=MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ListaProjekcijaDTO>>getListaProjekcija(@PathVariable(name="id") Long id){
        Sala sala=salaService.findById(id);
        List<ListaProjekcijaDTO> listaProjekcijaDTOS=new ArrayList<>();
        List<ListaProjekcija> listaProjekcijas=sala.getTerminska_lista_projekcija();
        for(ListaProjekcija lp: listaProjekcijas){
            ListaProjekcijaDTO listaProjekcijaDTO=new ListaProjekcijaDTO(lp.getId(),lp.getDan(),lp.getPocetak(),
                    lp.getCena(),lp.getNaziv(),lp.getZanr(),lp.getFilm().getTrajanje(),lp.getFilm().getOpis());
            listaProjekcijaDTOS.add(listaProjekcijaDTO);
        }
        return new ResponseEntity<>(listaProjekcijaDTOS,HttpStatus.OK);
    }







}
