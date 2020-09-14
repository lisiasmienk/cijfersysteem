package com.cs.cijferSysteem.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cs.cijferSysteem.controller.CijferService;
import com.cs.cijferSysteem.controller.DocentService;
import com.cs.cijferSysteem.controller.DocentVakService;
import com.cs.cijferSysteem.controller.KlasService;
import com.cs.cijferSysteem.controller.ToetsService;
import com.cs.cijferSysteem.controller.VakService;
import com.cs.cijferSysteem.domein.Cijfer;
import com.cs.cijferSysteem.domein.Docent;
import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Leerling;
import com.cs.cijferSysteem.domein.Toets;
import com.cs.cijferSysteem.domein.Vak;
import com.cs.cijferSysteem.dto.CijferDto;
import com.cs.cijferSysteem.dto.LeerlingCijfersVanDocentVakDto;

@RestController
public class CijferEndpoint {
	
	@Autowired
	CijferService tcs;
	@Autowired
	DocentVakService dvs;
	@Autowired
	ToetsService ts;
	@Autowired
	KlasService ks;
	@Autowired
	DocentService ds;
	@Autowired
	VakService vs;
	
    @GetMapping("/toetsCijferOverzicht")
    public Stream<CijferDto> geefOverzichtToetsCijfering() {
        return tcs.laatToetsCijfersZien().stream().map(c -> new CijferDto(c.getId(), c.getCijfer()));
    }
    
    @GetMapping("toonCijfersVan/{docentid}/{vakid}/{klasid}")
    public List<LeerlingCijfersVanDocentVakDto> leeringCijfersVanDocentVak(@PathVariable("docentid") Long docentid, @ PathVariable("vakid") Long vakid, @PathVariable("klasid") Long klasid) {
    	List<Leerling> leerlingen = ks.getKlasById(klasid).get().getLeerlingen();
    	
    	Optional <Docent> docentOptional = ds.toonDocentById(docentid);
    	Optional <Vak> vakOptional = vs.toonVakById(vakid);
    	
    	Docentvak dv = dvs.getByDocentAndVak(docentOptional.get(), vakOptional.get());
    	Iterable<Toets> toetsen = ts.findToetsByDocentvakAndKlas(dv.getId(), klasid);
    	    	
    	//Deze lijst wordt returned
    	List<LeerlingCijfersVanDocentVakDto> list = new ArrayList<>();

    	for(Leerling l : leerlingen) {
    		//In lijst 'cijfers' worden de cijfers van leerling l voor 'toetsen' opgeslagen
    		List<Float> cijfers = new ArrayList<>();
    		for(Toets t:  toetsen) {
        		//Haal alle cijfers op van deze toets
    			List<Cijfer> toetscijfers = t.getCijfers();
    			boolean gevonden = false;
    			for(Cijfer c : toetscijfers) {
    				//Zoek welk cijfer van de huidige leerling l is
    				if(c.getLeerling().getId() == l.getId()) {
    					cijfers.add(c.getCijfer());
    					gevonden = true;
    					break;
    				}
    			}
    			if(!gevonden) {
    				//Registreer voor elke toets wel een cijfer, ter voorkoming van verschuiving
    				cijfers.add(null);
    			}
    		}
    		LeerlingCijfersVanDocentVakDto dto = new LeerlingCijfersVanDocentVakDto(l.getVoornaam() + " " + l.getAchternaam(), cijfers);
        	list.add(dto);
    	}    	
    	return list;
    } 
}
