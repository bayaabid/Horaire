package com.horaire.service;

import java.util.List;

import com.horaire.model.JourTravail;

public interface IJourTravail {
	
	public JourTravail ajouterJourTravail(JourTravail jourTravail);
	
	public JourTravail updateJourTravail (JourTravail jourTravail);
	
	public void deleteJourTravail(JourTravail jourTravail );
	
	public List<JourTravail> allJoursTravail();

}
