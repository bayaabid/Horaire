package com.horaire.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
@DiscriminatorValue("DIS")
public class JourDisponible extends Jour implements Serializable {
 

	private static final long serialVersionUID = 1L;

	public JourDisponible() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JourDisponible(JourSemaine jourSemaine, Date dateJour, Semaine semaine) {
		super(jourSemaine, dateJour, semaine);
		// TODO Auto-generated constructor stub
	}
	
	

	

	

	
}
