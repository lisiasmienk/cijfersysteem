package com.cs.cijferSysteem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.cijferSysteem.domein.Docent;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocentService {


	@Autowired
	DocentRepository dr;

	@Transactional (readOnly = false)
	public void update(Docent d) {
		dr.save(d);
	}

	public void maakDocent(Docent docent) {
		dr.save(docent);
	}

	public Optional<Docent> toonDocentById(Long id) {
		return dr.findById(id);
	}

	public List<Docent> laatDocentZien() {
		return dr.findAll();
	}

	public Optional<Docent> getDocentById(Long id) {
		return dr.findById(id);
	}

}

