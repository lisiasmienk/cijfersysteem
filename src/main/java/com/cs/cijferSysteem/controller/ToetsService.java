package com.cs.cijferSysteem.controller;

import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Klas;
import com.cs.cijferSysteem.domein.Toets;
import com.cs.cijferSysteem.domein.Vak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToetsService {
    
	@Autowired
    ToetsRepository tr;

    public Toets save(Toets toets){
        return tr.save(toets);
    }

    public List<Toets> laatToetsZien(){
        return tr.findAll();
    }

    public Optional<Toets> toonToets(Long id) {
        return tr.findById(id);
    }
    
    public List<Toets> findToetsByDocentvak(Docentvak dv){
    	return tr.findByDocentvak(dv);
    }
    
    public List<Toets> findToetsByDocentvakAndKlas(Docentvak dv, Klas k){
    	return tr.findByDocentvakAndKlas(dv, k);
    }
    
    public List<Toets> findToetsByKlas(Klas k){
    	return tr.findByKlas(k);
    }
}
