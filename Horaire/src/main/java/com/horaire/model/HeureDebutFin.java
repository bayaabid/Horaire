package com.horaire.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HeureDebutFin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idHeure ;

	@ElementCollection(targetClass=String.class,fetch=FetchType.EAGER)
	@Column(length=5)
	private List<String> heures = new ArrayList<>();

	public HeureDebutFin() {
		super();
	}

	public List<String> getHeures() {
		return heures;
	}

	public void setHeures(List<String> heures) {
		this.heures = heures;
	}
	
	

}
