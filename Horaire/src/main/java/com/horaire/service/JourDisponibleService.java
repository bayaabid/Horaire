package com.horaire.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.JourDisponibleRepository;
import com.horaire.model.JourDisponible;
import com.horaire.model.Semaine;
import com.horaire.model.User;

@Service
public class JourDisponibleService implements IJourDisponible {

	@Autowired
	JourDisponibleRepository jourDisponiblerepository ;
	
	
	/*
	 * Enregistrer une journee
	 * */
	@Override
	public JourDisponible ajouterJourDisponible(JourDisponible jourDisponible) {
		
		return jourDisponiblerepository.save(jourDisponible);
	}

	/*
	 * Retourne la liste de tous les journees disponible
	 * */
	@Override
	public List<JourDisponible> allJoursDisponible() {
		
		return jourDisponiblerepository.findAll();
	}
	
	/*
	 * Mise a jour d'une journee
	 * */
	@Override
	public JourDisponible updatejourDidponible(JourDisponible jourDisponible) {
		
		return jourDisponiblerepository.saveAndFlush(jourDisponible);
	}

	/*
	 * Delete un jour disponible
	 * */
	@Override
	public void deleteJourDisponible(JourDisponible jourDisponible) {
		
		jourDisponiblerepository.delete(jourDisponible);
	}
	
	/* 
	 * Retoune la liste des employes disponiles du jour
	 * */
	@Override
	public List<User> getAllUsersDisponibleJour(Date date) {
		
			return jourDisponiblerepository.findAllUsersJourDisponible(date);
	}
	
	/*
	 * Retoune la liste des employes disponibles de la semaine
	 * */
	@Override
	public List<User> getAllUsersDisponibleSemaine(Semaine semaine) {
		
		return jourDisponiblerepository.findJourUserSemaine(semaine.getIdSemaine());
	}

	/*
	 * Retourne la liste des journees disponibles de la semaine d'un employe
	 * */
	@Override
	public List<JourDisponible> getAllJoursDisponibleSeamineUser(User user, Semaine semaine) {
		
		return jourDisponiblerepository.findAllJoursDisponibleSeamineUser(user.getId(),
				                                                           semaine.getIdSemaine());
	}

	/*
	 * Retourne un jour disponible par date
	 * */
	@Override
	public JourDisponible getJourDisponible(Date date) {
		
		return jourDisponiblerepository.findByDateJour(date);
	}

	/*
	 * Retourne un jour disponible pour un emplye
	 * */
	@Override
	public JourDisponible getJourDisponibleOfEmploye(Date date, User user) {
		
		return jourDisponiblerepository.findJourDisponibleOfEmploye(date,user.getId());
	}
	
	/*
	 * Retourne la semaine d'un jour disponible
	 * */
	@Override
	public Semaine getSemaineOfJourDisponible(Date date) {
		
		return jourDisponiblerepository.getSemaineOfJourDisponible(date);
	}

	/*
	 * Retourne la liste des employes qui font l'ouverture
	 * */
	@Override
	public List<User> getUsersOuvertureOfJourDisponible(boolean ouverture) {
		
		return jourDisponiblerepository.findUsersOuvertureDisponible(ouverture);
	}

	/*
	 * Retourne la liste des employes qui font la fermeture
	 * */
	@Override
	public List<User> getUsersFermetureOfJourDisponible(boolean fermeture) {
		
		return jourDisponiblerepository.findUsersFermetureOfJourDisponible(fermeture);
	}

	/*
	 * Retourne la liste des employes par heure de debut  quart de travail
	 * */
	@Override
	public List<User> getUsersByHeureDebutJourDisponible(String heureDebut) {
		
		return jourDisponiblerepository.findUsersByHeureDebutJourDisponible(heureDebut);
	}

	/*
	 * Retourne la liste des employes par heure de  fin  quart de travail
	 * */
	@Override
	public List<User> getUsersByHeureFinJourDisponible(String heureFin) {
		
		return jourDisponiblerepository.findUsersByHeureFinJourDisponible(heureFin);
	}

}
