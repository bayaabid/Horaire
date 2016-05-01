package com.horaire.dao;

import org.springframework.transaction.annotation.Transactional;

import com.horaire.model.JourDisponible;

@Transactional
public interface JourDisponibleRepository extends JourParentRepository<JourDisponible> {
	

}
