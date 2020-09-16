package com.cs.cijferSysteem.controller;

import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Klas;
import com.cs.cijferSysteem.domein.Toets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToetsRepository extends JpaRepository<Toets, Long> {

	List<Toets> findByKlas(Klas k);
	List<Toets> findByDocentvakAndKlas(Docentvak dv, Klas k);
	
	List<Toets> findByDocentvak(Docentvak dv);
}
