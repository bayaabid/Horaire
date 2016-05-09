package com.horaire.service;

import java.util.List;

import com.horaire.model.HeureDebutFin;

public interface IHeureDebutFin {
	
	public HeureDebutFin ajouterHeureDebutFin(HeureDebutFin heureDebutFin);
	
	public HeureDebutFin updateHeureDebutFin(HeureDebutFin heureDebutFin);
	
	public void detleteHeureDebutFin(HeureDebutFin heureDebutFin);
	
	public List<HeureDebutFin> getAllHeureDebutFin();

}
