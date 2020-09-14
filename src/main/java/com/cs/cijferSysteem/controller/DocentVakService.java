package com.cs.cijferSysteem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.cijferSysteem.domein.Docent;
import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Vak;


@Service
@Transactional
public class DocentVakService {
	@Autowired DocentVakRepository dvr;
	
	public void save(Docentvak dv) {
		dvr.save(dv);
	}
	
	public Optional<Docentvak> getDocentVakById(Long id){
		return dvr.findById(id);
	}
	
	public List<Docentvak> laatDocentVakkenZien(){
		return dvr.findAll();
	}
	
	public Docentvak getByDocentAndVak(Docent docent, Vak vak){
		return dvr.findByDocentAndVak(docent, vak);
	}
	
	public List<Docentvak> getByDocent(Docent docent){
		return dvr.findByDocent(docent);
	}
	
	public List<Docentvak> getByVak(Vak vak){
		return dvr.findByVak(vak);
	}
}
