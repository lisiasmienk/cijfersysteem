package com.cs.cijferSysteem.dto;

public class CijferDto {
	private Long id;
	private Float cijfer;
	
	public CijferDto() {}
	
	public CijferDto(Long id, Float cijfer) {
		super();
		this.id = id;
		this.cijfer = cijfer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getCijfer() {
		return cijfer;
	}
	public void setCijfer(Float cijfer) {
		this.cijfer = cijfer;
	}	
}
