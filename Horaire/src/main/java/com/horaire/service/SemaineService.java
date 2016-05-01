package com.horaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.SemaineRepositry;
import com.horaire.model.Semaine;

@Service
public class SemaineService implements ISemaine {
	
	@Autowired
	SemaineRepositry  semaineRepository ;

	@Override
	public Semaine ajouterSemaine(Semaine semaine) {
		// TODO Auto-generated method stub
		return semaineRepository.save(semaine);
	}

	@Override
	public void deleteSemaine(Semaine semaine) {
		
		semaineRepository.delete(semaine);
		
	}

	@Override
	public Semaine updateSemaine(Semaine semaine) {
		// TODO Auto-generated method stub
		return semaineRepository.saveAndFlush(semaine);
	}

	@Override
	public List<Semaine> allSemaine() {
		// TODO Auto-generated method stub
		return semaineRepository.findAll();
	}

}
