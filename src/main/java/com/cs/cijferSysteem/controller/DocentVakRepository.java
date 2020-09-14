package com.cs.cijferSysteem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cijferSysteem.domein.Docent;
import com.cs.cijferSysteem.domein.Docentvak;
import com.cs.cijferSysteem.domein.Vak;

public interface DocentVakRepository extends JpaRepository<Docentvak, Long> {
	Docentvak findByDocentAndVak(Docent docent, Vak vak);
	List<Docentvak> findByDocent(Docent docent);
	List<Docentvak> findByVak(Vak vak);
	Optional<Docentvak> findById(Long docentvakid);
}
