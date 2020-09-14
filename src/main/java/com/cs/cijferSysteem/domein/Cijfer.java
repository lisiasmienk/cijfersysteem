package com.cs.cijferSysteem.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cijfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Float cijfer;
	
	@ManyToOne
	private Leerling leerling;
	@ManyToOne
	private Toets toets;

	public Leerling getLeerling() {
		return leerling;
	}

	public void setLeerling(Leerling leerling) {
		this.leerling = leerling;
	}

	public Toets getToets() {
		return toets;
	}

	public void setToets(Toets toets) {
		this.toets = toets;
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

	public void setCijfer(float cijfer) {
		this.cijfer = cijfer;
	}
}
