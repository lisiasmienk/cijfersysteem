package com.cs.cijferSysteem.rest;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.cijferSysteem.controller.VakService;
import com.cs.cijferSysteem.domein.Vak;
import com.cs.cijferSysteem.dto.VakDto;

@RestController
public class VakEndpoint {
	
	@Autowired
	VakService vs;
	
	@GetMapping("/vakkenOverzicht")
	public Stream<VakDto> toonVakkenOverzicht(){
		return vs.laatVakZien().stream().map(v -> new VakDto(v.getId(), v.getNaam()));
	}

	@GetMapping("/vak/{id}")
	public Optional<VakDto> getVakById(@PathVariable("id") Long id){
		return vs.getVakById(id).map(v -> new VakDto(v.getId(), v.getNaam()));
	}
	
	@PostMapping("/api/maakVak")
	public void maakVak(@RequestBody Vak v) {
		vs.maakVak(v);
	}
	
}

