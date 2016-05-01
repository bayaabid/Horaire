package com.horaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.JourDisponibleRepository;
import com.horaire.model.JourDisponible;

@Service
public class JourDisponibleService implements IJourDisponible {

	@Autowired
	JourDisponibleRepository jourDisponiblerepository ;
	
	@Override
	public JourDisponible ajouterJourDisponible(JourDisponible jourDisponible) {
		// TODO Auto-generated method stub
		return jourDisponiblerepository.save(jourDisponible);
	}

	@Override
	public List<JourDisponible> allJoursDisponible() {
		// TODO Auto-generated method stub
		return jourDisponiblerepository.findAll();
	}

	@Override
	public JourDisponible updatejourDidponible(JourDisponible jourDisponible) {
		// TODO Auto-generated method stub
		return jourDisponiblerepository.saveAndFlush(jourDisponible);
	}

	@Override
	public void deleteJourDisponible(JourDisponible jourDisponible) {
		// TODO Auto-generated method stub
		jourDisponiblerepository.delete(jourDisponible);
	}

}
