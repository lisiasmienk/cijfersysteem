package com.cs.cijferSysteem.domein;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vak {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String naam;
	
	@OneToMany
	private List<Docentvak> docentvakken;

	public List<Docent> getDocenten() {
		List<Docent> docenten = new ArrayList<>();
		for(Docentvak dv : docentvakken) {
			docenten.add(dv.getDocent());
		}
		return docenten;
	}	
	
	public void voegDocentVakToe(Docentvak dv) {
		docentvakken.add(dv);
	}

	public List<Docentvak> getDocentvakken() {
		return docentvakken;
	}

	public void setDocentvakken(List<Docentvak> docentvakken) {
		this.docentvakken = docentvakken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && ((Vak) obj).naam.equals(this.naam);
//		if (obj == null) {
//			return false;
//		}
//		if (obj instanceof Vak) {
//			return ((Vak) obj).getNaam().equals(this.naam);
//
//		} else {
//			return false;
//		}
	}

}
