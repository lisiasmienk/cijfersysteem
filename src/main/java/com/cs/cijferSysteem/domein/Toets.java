package com.cs.cijferSysteem.domein;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Toets {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate datum;
	private LocalTime tijd;

	@ManyToOne(optional = false)
	private Klas klas;

	@ManyToOne (optional = false)
	private Docentvak docentvak;

	@OneToMany ()
	private List<Cijfer> cijfers;

	public void voegCijferToe(Cijfer tc) {
		cijfers.add(tc);
	}

	public void setCijfers(List<Cijfer> cijfers) {
		this.cijfers = cijfers;
	}

	public List<Cijfer> getCijfers() {
		return cijfers;
	}

	public LocalTime getTijd() {
		return tijd;
	}

	public void setTijd(LocalTime tijd) {
		this.tijd = tijd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Vak getVak() {
		return docentvak.getVak();
	}

	public Docent getDocent() {
		return docentvak.getDocent();
	}

	public Klas getKlas() {
		return klas;
	}

	public void setKlas(Klas klas) {
		this.klas = klas;
	}

	public Docentvak getDocentvak() {
		return docentvak;
	}

	public void setDocentvak(Docentvak docentvak) {
		this.docentvak = docentvak;
	}

}
