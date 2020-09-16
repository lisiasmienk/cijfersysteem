package com.cs.cijferSysteem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.cijferSysteem.domein.Cijfer;
import com.cs.cijferSysteem.domein.Leerling;
import com.cs.cijferSysteem.domein.Toets;

@Service
@Transactional
public class CijferService {
	
	@Autowired
	CijferRepository tcr;
	
	public void save(Cijfer tc) {
		tcr.save(tc);
	}
	
	public Optional<Cijfer> getToetsCijferById(Long id){
		return tcr.findById(id);
	}
	
	public List<Cijfer> laatToetsCijfersZien(){
		return tcr.findAll();
	}
	
	public List<Cijfer> cijfersVanLeerling(Leerling l){
		return tcr.findByLeerling(l);
	}
	
	public List<Cijfer> cijfersVanToets(Toets t){
		return tcr.findByToets(t);
	}
}
