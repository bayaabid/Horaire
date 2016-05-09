package com.horaire.service;

import java.util.Date;
import java.util.List;

import com.horaire.model.JourTravail;
import com.horaire.model.Semaine;
import com.horaire.model.User;

public interface IJourTravail {
	
public JourTravail ajouterJourTravail (JourTravail jourTravail);
	
	public JourTravail getJourTravail(Date date);
	
	public JourTravail updatejourTravail(JourTravail jourTravail);
	
	public void deleteJourTravail(JourTravail jourTravail);
	
	public List<JourTravail> allJoursTravail ();
	
	public List<User> getAllUsersTravailJour(Date date);
	
	public List<User> getAllUsersTravailSemaine(Semaine semaine);
	
	public List<JourTravail> getAllJoursTravailSeamineUser(User user , Semaine semaine);
	
	public JourTravail getJourTravailOfEmploye(Date date , User user);
	
	public Semaine getSemaineOfJourTravail(Date date);

}
