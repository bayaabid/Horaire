package com.horaire.web.util;

import java.util.Calendar;
import java.util.Date;

public class JourOfSemaine {
	
	private Date dateJour = new Date();
	
	public int jourDeLaSemaine(){
		
		Calendar c = Calendar.getInstance();
		c.setTime(dateJour);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek;
	}
	
	public String NomJourSemaine(){
		
		switch (jourDeLaSemaine()) {
		case 1:
			return "DIMANCHE";
		default:
			return "";
			
		}
	}
	

}
