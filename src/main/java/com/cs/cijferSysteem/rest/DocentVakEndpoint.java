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
import com.cs.cijferSysteem.controller.VakService;
import com.cs.cijferSysteem.domein.Docent;
import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Klas;
import com.cs.cijferSysteem.domein.Vak;
import com.cs.cijferSysteem.dto.DocentVakDto;
import com.cs.cijferSysteem.dto.KlasDto;

@RestController
public class DocentVakEndpoint {
	@Autowired
	DocentVakService dvs;
	@Autowired
	DocentService ds;
	@Autowired
	VakService vs;
	
	@GetMapping("/docentVakOverzicht")
	public Stream<DocentVakDto> geefDocentVakOverzicht(){
		return dvs.laatDocentVakkenZien().stream().map(dv -> new DocentVakDto(dv.getId(), dv.getDocent().getId(), dv.getVak().getId(), dv.getDocent().getAchternaam(), dv.getVak().getNaam()));
	}
	
	@GetMapping("/klassenVanDocentEnVak/{docentid}/{vakid}")
	public Stream<KlasDto> geefKlassenVanDocentVak(@PathVariable("docentid") Long docentid, @PathVariable("vakid") Long vakid){
		
    	Optional <Docent> docentOptional = ds.toonDocentById(docentid);
    	Optional <Vak> vakOptional = vs.toonVakById(vakid);
    	
		List<Klas> klassen = dvs.getByDocentAndVak(docentOptional.get(), vakOptional.get()).getKlassen();
		return klassen.stream().map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}
	
	@GetMapping("/klassenVanDocentVak/{docentvakid}}")
	public Stream<KlasDto> geefKlassenVanDocentVak(@PathVariable("docentvakid") Long docentvakid){
		List<Klas> klassen = dvs.getDocentVakById(docentvakid).get().getKlassen();
		return klassen.stream().map(k -> new KlasDto(k.getId(), k.getNaam(), k.getNiveau()));
	}
	
	@PostMapping("/maakDocentVak")
	public void maakDocentVak(@RequestBody DocentVakDto dto) {
		Docentvak dv = new Docentvak();
		Docent d = ds.getDocentById(dto.getDocentid()).get();
		Vak v = vs.getVakById(dto.getVakid()).get();
		dv.setDocent(d);
		dv.setVak(v);
		dvs.save(dv);
		
		d.voegDocentVakToe(dv);
		ds.update(d);
		v.voegDocentVakToe(dv);
		vs.update(v);
	}
}
