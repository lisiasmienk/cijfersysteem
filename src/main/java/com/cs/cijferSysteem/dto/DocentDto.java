package com.cs.cijferSysteem.dto;

public class DocentDto {
	Long id;
	String achternaam;
	String voornaam;
	
	public DocentDto() {}
	
	public DocentDto(Long id, String achternaam, String voornaam) {
		super();
		this.id = id;
		this.achternaam = achternaam;
		this.voornaam = voornaam;
	}

		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
