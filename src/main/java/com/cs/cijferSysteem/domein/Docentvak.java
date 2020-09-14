package com.cs.cijferSysteem.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import javax.persistence.*;

@Entity
public class Docentvak {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Vak vak;
	@ManyToOne
	private Docent docent;
	
	@ManyToMany
	private List<Klas> klassen;
	@OneToMany
	private List<Toets> toetsen;
	
	public void voegKlasToe(Klas k) {
		klassen.add(k);
	}
	public void voegToetsToe(Toets t) {
		toetsen.add(t);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Vak getVak() {
		return vak;
	}
	public void setVak(Vak vak) {
		this.vak = vak;
	}
	public Docent getDocent() {
		return docent;
	}
	public void setDocent(Docent docent) {
		this.docent = docent;
	}
	
	public String toString() {
		return "id: " + id + " vakid: " + vak.getId() + " docentid: " + docent.getId();
	}

	public List<Klas> getKlassen() {
		return klassen;
	}

	public void setKlassen(List<Klas> klassen) {
		this.klassen = klassen;
	}

	public List<Toets> getToetsen() {
		return toetsen;
	}

	public void setToetsen(List<Toets> toetsen) {
		this.toetsen = toetsen;
	}
}
