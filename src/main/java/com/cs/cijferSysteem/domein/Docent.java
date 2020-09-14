package com.cs.cijferSysteem.domein;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Docent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String achternaam;
	private String voornaam;

	@OneToMany
	private List<Docentvak> docentvakken;

	public void voegDocentVakToe(Docentvak dv) {
		docentvakken.add(dv);
	}

	public List<Vak> getVakken() {
		List<Vak> vakken = new ArrayList<>();
		for(Docentvak dv : docentvakken) {
			vakken.add(dv.getVak());
		}
		return vakken;
	}

	public List<Docentvak> getDocentvakken() {
		return docentvakken;
	}

	public void setDocentvakken(List<Docentvak> docentvakken) {
		this.docentvakken = docentvakken;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
