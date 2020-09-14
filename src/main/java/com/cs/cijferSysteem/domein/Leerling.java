package com.cs.cijferSysteem.domein;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Leerling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int leerlingNummer;
	private String voornaam;
	private String achternaam;
	private LocalDate geboorteDatum;

	@ManyToMany(mappedBy = "leerlingen", cascade = CascadeType.ALL)
	private List<Klas> klassen;
	
	@OneToMany
	private List<Cijfer> cijfers;
	
	public void voegKlasToe(Klas k) {
		klassen.add(k);
	}
	
	public void voegCijferToe(Cijfer tc) {
		cijfers.add(tc);
	}
	
	public List<Cijfer> getCijfers() {
		return cijfers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(LocalDate geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public long getLeerlingNummer() {
		return leerlingNummer;
	}

	public void setLeerlingNummer(int leerlingNummer) {
		this.leerlingNummer = leerlingNummer;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public List<Klas> getKlassen() {
		return klassen;
	}
	
}

