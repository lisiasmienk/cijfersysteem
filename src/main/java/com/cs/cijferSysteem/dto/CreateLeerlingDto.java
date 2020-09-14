package com.cs.cijferSysteem.dto;

public class CreateLeerlingDto {

	Long id;
    String voornaam;
    String achternaam;
    String geboortedatum;
    String leerlingnummer;


    public CreateLeerlingDto() {};
    
    public CreateLeerlingDto(Long id, String voornaam, String achternaam, String geboortedatum) {
		super();
		this.id = id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLeerlingnummer() {
		return leerlingnummer;
	}

	public void setLeerlingnummer(String leerlingnummer) {
		this.leerlingnummer = leerlingnummer;
	}

	public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }
}
