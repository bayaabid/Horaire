package com.horaire.service;

import java.util.List;

import com.horaire.model.JourDisponible;

public interface IJourDisponible {
	
	public JourDisponible ajouterJourDisponible (JourDisponible jourDisponible);
	
	public JourDisponible updatejourDidponible(JourDisponible jourDisponible);
	
	public void deleteJourDisponible(JourDisponible jourDisponible);
	
	public List<JourDisponible> allJoursDisponible ();

}
