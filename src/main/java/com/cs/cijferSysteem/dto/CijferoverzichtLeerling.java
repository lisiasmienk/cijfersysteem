package com.cs.cijferSysteem.dto;

import java.util.List;

public class CijferoverzichtLeerling {
	String vaknaam;
	List<Float> cijfers;
	
	public CijferoverzichtLeerling(String vak, List<Float> cijfers) {
		super();
		this.vaknaam = vak;
		this.cijfers = cijfers;
	}
	
	public String getVaknaam() {
		return vaknaam;
	}
	public void setVaknaam(String vaknaam) {
		this.vaknaam = vaknaam;
	}
	public List<Float> getCijfers() {
		return cijfers;
	}
	public void setCijfers(List<Float> cijfers) {
		this.cijfers = cijfers;
	}
}
