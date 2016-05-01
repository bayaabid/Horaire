package com.horaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.JourTravailRepository;
import com.horaire.model.JourTravail;

@Service
public class JourTravailService implements IJourTravail {

	@Autowired
	JourTravailRepository jourTravailrepository ;
	
	@Override
	public JourTravail ajouterJourTravail(JourTravail jourTravail) {
		// TODO Auto-generated method stub
		return jourTravailrepository.save(jourTravail);
	}

	@Override
	public List<JourTravail> allJoursTravail() {
		// TODO Auto-generated method stub
		return jourTravailrepository.findAll();
	}

	@Override
	public JourTravail updateJourTravail(JourTravail jourTravail) {
		// TODO Auto-generated method stub
		return jourTravailrepository.saveAndFlush(jourTravail);
	}

	@Override
	public void deleteJourTravail(JourTravail jourTravail) {
		// TODO Auto-generated method stub
		jourTravailrepository.delete(jourTravail);
	}

}
