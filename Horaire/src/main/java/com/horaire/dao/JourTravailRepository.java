package com.horaire.dao;

import org.springframework.transaction.annotation.Transactional;

import com.horaire.model.JourTravail;

@Transactional
public interface JourTravailRepository extends JourParentRepository<JourTravail> {
	
	

}
