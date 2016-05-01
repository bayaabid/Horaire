package com.horaire.service;

import java.util.List;

import com.horaire.model.Semaine;


public interface ISemaine {
	
	public Semaine ajouterSemaine(Semaine semaine);
	
	public void deleteSemaine (Semaine semaine);
	
	public Semaine updateSemaine(Semaine semaine);
	
	public List<Semaine> allSemaine();

}
