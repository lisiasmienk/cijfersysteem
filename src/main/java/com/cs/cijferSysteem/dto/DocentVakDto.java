package com.cs.cijferSysteem.dto;

public class DocentVakDto {
	Long id;
	Long docentid;
	Long vakid;
	String docentAchternaam;
	String vaknaam;
	
	public DocentVakDto() {};
	
	public DocentVakDto(Long id, Long docentid, Long vakid, String docentAchternaam, String vaknaam) {
		super();
		this.id = id;
		this.docentid = docentid;
		this.vakid = vakid;
		this.docentAchternaam = docentAchternaam;
		this.vaknaam = vaknaam;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Long getDocentid() {
		return docentid;
	}
	public void setDocentid(Long docentid) {
		this.docentid = docentid;
	}
	public Long getVakid() {
		return vakid;
	}
	public void setVakid(Long vakid) {
		this.vakid = vakid;
	}
	public String getDocentAchternaam() {
		return docentAchternaam;
	}
	public void setDocentAchternaam(String docentAchternaam) {
		this.docentAchternaam = docentAchternaam;
	}
	public String getVaknaam() {
		return vaknaam;
	}
	public void setVaknaam(String vaknaam) {
		this.vaknaam = vaknaam;
	}
}
