package com.cs.cijferSysteem.controller;

import com.cs.cijferSysteem.domein.Toets;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToetsRepository extends JpaRepository<Toets, Long> {

	List<Toets> findByCijfersId(Long toetsid);
	List<Toets> findByDocentvakId(Long docentvakid);
	List<Toets> findByKlasId(Long klasid);
	List<Toets> findByDocentvakIdAndKlasId(Long docentvakid, Long klasid);
}
