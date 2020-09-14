package com.cs.cijferSysteem.dto;

public class VakDto {
	Long id;
	String naam;
	
	public VakDto() {};
	
	public VakDto(Long id, String naam) {
		super();
		this.id = id;
		this.naam = naam;
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
}
