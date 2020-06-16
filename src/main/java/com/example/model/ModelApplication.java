package com.example.model;

import com.example.model.entity.Korisnik;
import com.example.model.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ModelApplication  {



	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}


}
