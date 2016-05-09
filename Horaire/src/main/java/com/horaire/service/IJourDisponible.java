package com.horaire.service;

import java.util.Date;
import java.util.List;

import com.horaire.model.JourDisponible;
import com.horaire.model.Semaine;
import com.horaire.model.User;

public interface IJourDisponible {
	
	public JourDisponible ajouterJourDisponible (JourDisponible jourDisponible);
	
	public JourDisponible getJourDisponible(Date date);
	
	public JourDisponible updatejourDidponible(JourDisponible jourDisponible);
	
	public void deleteJourDisponible(JourDisponible jourDisponible);
	
	public List<JourDisponible> allJoursDisponible ();
	
	public List<User> getAllUsersDisponibleJour(Date date);
	
	public List<User> getAllUsersDisponibleSemaine(Semaine semaine);
	
	public List<JourDisponible> getAllJoursDisponibleSeamineUser(User user , Semaine semaine);
	
	public JourDisponible getJourDisponibleOfEmploye(Date date , User user);
	
	public Semaine getSemaineOfJourDisponible(Date date);
	
	public List<User> getUsersOuvertureOfJourDisponible(boolean ouverture);
	
	public List<User> getUsersFermetureOfJourDisponible(boolean fermeture);
	
	public List<User> getUsersByHeureDebutJourDisponible(String heureDebut);
	
	public List<User> getUsersByHeureFinJourDisponible(String heureFin);

}
