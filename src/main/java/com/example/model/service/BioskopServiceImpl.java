package com.example.model.service;

import com.example.model.DTO.BioskopDTO;
import com.example.model.DTO.SalaDTO;
import com.example.model.entity.Bioskop;
import com.example.model.entity.EnumUloga;
import com.example.model.entity.Sala;
import com.example.model.repository.BioskopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.DTO.KorisnikDTO;

import java.util.ArrayList;
import java.util.Set;
@Service
public class BioskopServiceImpl implements BioskopService{
    @Autowired
    private BioskopRepository bioskopRepository;
    @Autowired
    private SalaService salaService;
    @Override
    public BioskopDTO dodajBioskop(BioskopDTO bioskopDTO){
        KorisnikDTO korisnik=new KorisnikDTO();
        if(korisnik.getUloga()== EnumUloga.ADMINISTRATOR) {
            Bioskop bioskop = new Bioskop(bioskopDTO.getNaziv(), bioskopDTO.getAdresa(), bioskopDTO.getBrojTelefonaCentrale(),
                    bioskopDTO.geteMail());
            Bioskop postojiBioskop = bioskopRepository.findByNaziv(bioskopDTO.getNaziv());
            if (postojiBioskop == null) {
                Set<Sala> sale = salaService.dodajSalu(bioskopDTO.getSale());
                bioskop.setSale(sale);
                bioskopRepository.save(bioskop);
                ArrayList<SalaDTO> salaDTOS = SaleDTO(bioskop.getSale());
                BioskopDTO bioskopD = new BioskopDTO(bioskop.getNaziv(), bioskop.getAdresa(),
                        bioskop.getBrojTelefonaCentrale(), bioskop.getE_mail(),
                        salaDTOS);
                return bioskopD;
            } else {
                return null;
            }
        }else{
            return null;
        }


    }

    private ArrayList<SalaDTO> SaleDTO(Set<Sala>sale){
        ArrayList<SalaDTO>salaDTOS=new ArrayList<>();
        for(Sala s: sale){
            SalaDTO salaDTO= new SalaDTO(s.getKapacitet(),s.getOznaka_sale());
            salaDTOS.add(salaDTO);
        }
        return salaDTOS;
    }
}
