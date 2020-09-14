package com.cs.cijferSysteem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.cijferSysteem.domein.Klas;

@Service
@Transactional
public class KlasService {

	@Autowired
	KlasRepository kr;
	
	@Transactional(readOnly = false)
	public void update(Klas k) {
		kr.save(k);
	}

	public List<Klas> laatKlasZien(){
		return kr.findAll();
	}
	
	public Optional<Klas> getKlasById(Long id) {
		return kr.findById(id);
	}
	
}
