package com.cs.cijferSysteem.dto;

public class KlasDto {
	Long id;
	String naam;
	String niveau;
	
	public KlasDto(){};
	
	public KlasDto(Long id, String naam, String niveau) {
		this.id = id;
		this.naam = naam;
		this.niveau = niveau;
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
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
}
