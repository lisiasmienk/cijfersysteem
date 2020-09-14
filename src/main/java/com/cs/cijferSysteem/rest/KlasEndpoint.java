package com.cs.cijferSysteem.rest;

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
import com.cs.cijferSysteem.controller.DocentVakService;
import com.cs.cijferSysteem.controller.KlasService;
import com.cs.cijferSysteem.controller.LeerlingService;
import com.cs.cijferSysteem.controller.VakService;


import com.cs.cijferSysteem.domein.Docent;


import com.cs.cijferSysteem.domein.Docentvak;

import com.cs.cijferSysteem.domein.Klas;
import com.cs.cijferSysteem.domein.Leerling;
import com.cs.cijferSysteem.domein.Vak;
import com.cs.cijferSysteem.dto.CreateLeerlingDto;
import com.cs.cijferSysteem.dto.DocentVakDto;
import com.cs.cijferSysteem.dto.KlasDto;
import com.cs.cijferSysteem.dto.KlasLeerlingDto;

@RestController
public class KlasEndpoint {

	@Autowired
	KlasService ks;
	@Autowired
	LeerlingService ls;	
	@Autowired
	VakService vs;	
	@Autowired
	DocentVakService dvs;	
	@Autowired
	DocentService ds;
	
	@GetMapping("/klassenOverzicht")
	public Stream<KlasDto> toonKlassenOverzicht(){
		return ks.laatKlasZien().stream().map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}
	

	@GetMapping("/klas/{klasid}")
	public Optional<KlasDto> getKlasById(@PathVariable("klasid") Long klasid){
		return ks.getKlasById(klasid).map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}

	@GetMapping("/vakkenVanKlas/{id}")
	public Stream<DocentVakDto> toonVakkenVanKlas(@PathVariable("id") Long id){
		List<Docentvak> docentvakken = ks.getKlasById(id).get().getDocentvakken();
		return docentvakken.stream().map(d -> new DocentVakDto(d.getId(), d.getDocent().getId(), d.getVak().getId(), d.getDocent().getAchternaam(), d.getVak().getNaam()));

	}
	
	@GetMapping("/leerlingenInKlas/{klasid}")
	public Stream<CreateLeerlingDto> toonLeerlingenVanKlas(@PathVariable("klasid") Long klasid){
		Klas k = ks.getKlasById(klasid).get();
		return k.getLeerlingen().stream().map(l -> new CreateLeerlingDto(l.getId(), l.getVoornaam(), l.getAchternaam(), l.getGeboorteDatum().toString()));
	}
	
	@PostMapping("/api/maakKlas")
	public void maakVak(@RequestBody Klas k) {
		System.out.println(k.getId());
		ks.update(k);
	}
	
	@PostMapping("api/editKlas/{id}")
	public void updateKlas(@RequestBody Klas klas) { 
		ks.update(klas);
	}
	
	@PostMapping("/api/voegLeerlingToe")
	public void voegLeerlingToe(@RequestBody KlasLeerlingDto klasLeerlingDto) {
		System.out.println(klasLeerlingDto.getKlasid() + " " + klasLeerlingDto.getLeerlingid());
		Klas k = ks.getKlasById(klasLeerlingDto.getKlasid()).get();
		Leerling l = ls.toonLeerling(klasLeerlingDto.getLeerlingid()).get();
		if(!k.getLeerlingen().contains(l)) {
			k.getLeerlingen().add(l);
			ks.update(k);
		}
		l.voegKlasToe(k);
		ls.save(l);
	}
	
	@PostMapping("/api/voegDocentVakToe/{klasid}")
	public void voegDocentVakToe(@PathVariable("klasid") Long klasid, @RequestBody DocentVakDto dto) {
    	Docentvak dv = dvs.getDocentVakById(dto.getId()).get();
    	Klas k = ks.getKlasById(klasid).get();
    	
		k.voegDocentVakToe(dv);
		dv.voegKlasToe(k);
		
		ks.update(k);
		dvs.save(dv);
	}
}
