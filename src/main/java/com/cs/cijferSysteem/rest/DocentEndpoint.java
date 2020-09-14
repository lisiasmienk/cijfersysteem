package com.cs.cijferSysteem.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.cijferSysteem.controller.DocentService;

import com.cs.cijferSysteem.controller.VakService;
import com.cs.cijferSysteem.domein.Docent;

import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Klas;

import com.cs.cijferSysteem.domein.Vak;
import com.cs.cijferSysteem.dto.DocentDto;
import com.cs.cijferSysteem.dto.KlasDto;
import com.cs.cijferSysteem.dto.VakDto;

@RestController
public class DocentEndpoint {
	@Autowired
	DocentService ds;
	@Autowired
	VakService vs;
	
	@PostMapping("api/maakDocent")
	public void maakDocent(@RequestBody Docent docent) { 
		ds.maakDocent(docent);
	}
	

	@PostMapping("api/editDocent/{id}")
	public void updateDocent(@RequestBody Docent docent) { 
		ds.update(docent);
	}


	@PostMapping("/api/voegDocentVakToeAanDocent/{docentid}")
	public void voegDocentVakToeAanDocent(@PathVariable("docentid") Long docentid, @RequestBody Docentvak dv) {
		ds.toonDocentById(docentid).get().voegDocentVakToe(dv);
	} 
	
	@GetMapping("/docentOverzicht")
	public Stream<DocentDto> geefOverzichtDocent() {
		return ds.laatDocentZien().stream().map(d -> new DocentDto(d.getId(), d.getAchternaam(), d.getVoornaam()));

	}
	
	@GetMapping("/docent/{id}")
	public Optional<DocentDto> getDocentById(@PathVariable("id")Long id){ 
		return ds.toonDocentById(id).map(d -> new DocentDto(d.getId(), d.getAchternaam(), d.getVoornaam()));
	}
	
	@GetMapping("/vakkenVanDocent/{docentid}")
	public Stream<VakDto> getVakvanDocent(@PathVariable("docentid")Long docentid){ 
		List<Vak> vakken = ds.getDocentById(docentid).get().getVakken();
		return vakken.stream().map(v -> new VakDto(v.getId(), v.getNaam()));
	}
	
	@GetMapping("/klassenVanDocent/{docentid}")
	public Stream<KlasDto> getKlassenVanDocent(@PathVariable("docentid")Long docentid){ 
		List<Klas> klassen = new ArrayList<>();
		ds.getDocentById(docentid).get().getDocentvakken().forEach(dv -> klassen.addAll(dv.getKlassen()));
		return klassen.stream().map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}
	
	@GetMapping("/docentenVanVak/{vakid}")
	public Stream<DocentDto> getDocentenVanVak(@PathVariable("vakid") Long vakid){ 
		List<Docent> docenten = vs.getVakById(vakid).get().getDocenten();
		return docenten.stream().map(d -> new DocentDto(d.getId(), d.getAchternaam(), d.getVoornaam()));
	}
	
} 

