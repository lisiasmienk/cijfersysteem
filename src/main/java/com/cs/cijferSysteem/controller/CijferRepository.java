package com.cs.cijferSysteem.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.cijferSysteem.domein.Cijfer;
import com.cs.cijferSysteem.domein.Leerling;
import com.cs.cijferSysteem.domein.Toets;

public interface CijferRepository extends JpaRepository <Cijfer, Long> {
	List<Cijfer> findByLeerling(Leerling l);
	List<Cijfer> findByToets(Toets t);
}
