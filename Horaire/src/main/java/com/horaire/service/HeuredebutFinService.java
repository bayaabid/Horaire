package com.horaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horaire.dao.HeureDebutFinRepository;
import com.horaire.model.HeureDebutFin;

@Service
public class HeuredebutFinService implements IHeureDebutFin {
	
	@Autowired
	HeureDebutFinRepository heureDebutfinRepository ;

	@Override
	public HeureDebutFin ajouterHeureDebutFin(HeureDebutFin heureDebutFin) {
		
		return heureDebutfinRepository.save(heureDebutFin);
	}

	@Override
	public HeureDebutFin updateHeureDebutFin(HeureDebutFin heureDebutFin) {
		
		return heureDebutfinRepository.saveAndFlush(heureDebutFin);
	}

	@Override
	public void detleteHeureDebutFin(HeureDebutFin heureDebutFin) {
		
		heureDebutfinRepository.delete(heureDebutFin);
	}

	@Override
	public List<HeureDebutFin> getAllHeureDebutFin() {
		
		return heureDebutfinRepository.findAll();
	}

}
