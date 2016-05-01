package com.horaire.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRA")
public class JourTravail extends Jour implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public JourTravail() {
		super();
	}

	public JourTravail(JourSemaine jourSemaine, Date dateJour, Semaine semaine) {
		super(jourSemaine, dateJour, semaine);
	}
	
	

}
