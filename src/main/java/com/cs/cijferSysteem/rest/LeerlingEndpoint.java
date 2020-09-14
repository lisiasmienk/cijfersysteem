package com.cs.cijferSysteem.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;
import com.cs.cijferSysteem.dto.CijferDto;
import com.cs.cijferSysteem.dto.CreateLeerlingDto;
import com.cs.cijferSysteem.dto.KlasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cs.cijferSysteem.controller.LeerlingService;
import com.cs.cijferSysteem.domein.Leerling;

@RestController
public class LeerlingEndpoint {

	@Autowired
	LeerlingService ls;

	@GetMapping("/leerlingOverzicht")
	public Stream<CreateLeerlingDto> geefOverzichtLeerling() {
		return ls.laatLeerlingZien().stream().map(l -> new CreateLeerlingDto(l.getId(), l.getVoornaam(), l.getAchternaam(), l.getGeboorteDatum().toString()));
	}

	@GetMapping("/leerling/{id}")
	public Optional<CreateLeerlingDto> getLeerlingById(@PathVariable("id") Long id){
		return ls.toonLeerling(id).map(l -> new CreateLeerlingDto(l.getId(), l.getAchternaam(), l.getVoornaam(), l.getGeboorteDatum().toString()));
	}

	@GetMapping("/cijfersVanLeerling/{id}")
	public Stream<CijferDto> toonCijfersVanLeerling(@PathVariable("id") Long id){
		return ls.toonLeerling(id).get().getCijfers().stream().map(c -> new CijferDto(c.getId(), c.getCijfer()));
	}

	@GetMapping("/klassenVanLeerling/{leerlingid}")
	public Stream<KlasDto> toonKlassenVanLeerling(@PathVariable("leerlingid")Long leerlingid){
		return ls.toonLeerling(leerlingid).get().getKlassen().stream().map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}

	@PostMapping("/api/maakLeerling")
	public void maakLeerlingAan(@RequestBody CreateLeerlingDto createLeerlingDto){
		Leerling leerling = new Leerling();
		leerling.setVoornaam(createLeerlingDto.getVoornaam());
		leerling.setAchternaam(createLeerlingDto.getAchternaam());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		leerling.setGeboorteDatum(LocalDate.parse(createLeerlingDto.getGeboortedatum(), formatter));
		try{
			leerling.setLeerlingNummer(Integer.valueOf(createLeerlingDto.getLeerlingnummer()));
		}catch (Exception e){
			System.out.println("Wij vullen het leerlingnummer niet zelf in. Deze wordt gegenereerd als id");
		}
		this.ls.save(leerling);
	}

	@PostMapping("api/editLeerling/{id}")
	public void update(@RequestBody CreateLeerlingDto createLeerlingDto, @PathVariable("id") Long id) { 
		Leerling leerling = ls.toonLeerling(id).get();
		leerling.setVoornaam(createLeerlingDto.getVoornaam());
		leerling.setAchternaam(createLeerlingDto.getAchternaam());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		leerling.setGeboorteDatum(LocalDate.parse(createLeerlingDto.getGeboortedatum(), formatter));
		leerling.setLeerlingNummer(Integer.valueOf(createLeerlingDto.getLeerlingnummer()));
		this.ls.save(leerling);
	}
}