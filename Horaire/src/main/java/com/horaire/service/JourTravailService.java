package com.horaire.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.JourTravailRepository;
import com.horaire.model.JourTravail;
import com.horaire.model.Semaine;
import com.horaire.model.User;

@Service
public class JourTravailService implements IJourTravail {

	@Autowired
	JourTravailRepository jourTravailrepository ;

	/*
	 * Enregistrer une journee
	 * */
	@Override
	public JourTravail ajouterJourTravail(JourTravail jourTravail) {
		
		return jourTravailrepository.save(jourTravail);
	}

	/*
	 * Retourne la liste de tous les journees Travail
	 * */
	@Override
	public List<JourTravail> allJoursTravail() {
		
		return jourTravailrepository.findAll();
	}
	
	/*
	 * Mise a jour d'une journee
	 * */
	@Override
	public JourTravail updatejourTravail(JourTravail jourTravail) {
		
		return jourTravailrepository.saveAndFlush(jourTravail);
	}

	/*
	 * Delete un jour de travail
	 * */
	@Override
	public void deleteJourTravail(JourTravail jourTravail) {
		
		jourTravailrepository.delete(jourTravail);
	}
	
	/* 
	 * Retoune la liste des employes Travails du jour
	 * */
	@Override
	public List<User> getAllUsersTravailJour(Date date) {
		
			return jourTravailrepository.findAllUsersJourTravail(date);
	}
	
	/*
	 * Retoune la liste des employes Travails de la semaine
	 * */
	@Override
	public List<User> getAllUsersTravailSemaine(Semaine semaine) {
		
		return jourTravailrepository.findJourUserSemaine(semaine.getIdSemaine());
	}

	/*
	 * Retourne la liste des journees Travails de la semaine d'un employe
	 * */
	@Override
	public List<JourTravail> getAllJoursTravailSeamineUser(User user, Semaine semaine) {
		
		return jourTravailrepository.findAllJoursTravailSeamineUser(user.getId(),
				                                                           semaine.getIdSemaine());
	}

	/*
	 * Retourne un jour Travail par date
	 * */
	@Override
	public JourTravail getJourTravail(Date date) {
		
		return jourTravailrepository.findByDateJour(date);
	}

	/*
	 * Retourne un jour Travail pour un emplye
	 * */
	@Override
	public JourTravail getJourTravailOfEmploye(Date date, User user) {
		
		return jourTravailrepository.findJourTravailOfEmploye(date,user.getId());
	}
	
	/*
	 * Retourne la semaine d'un jour Travail
	 * */
	@Override
	public Semaine getSemaineOfJourTravail(Date date) {
		
		return jourTravailrepository.getSemaineOfJourTravail(date);
	}


}
