package com.horaire;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;


import com.horaire.model.JourDisponible;
import com.horaire.model.JourSemaine;
import com.horaire.model.JourTravail;
import com.horaire.model.Semaine;
import com.horaire.service.IJourDisponible;
import com.horaire.service.IJourTravail;
import com.horaire.service.ISemaine;


@SpringBootApplication
public class HoraireApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HoraireApplication.class, args);
		
		IJourDisponible jourDis = ctx.getBean(IJourDisponible.class);
		
		IJourTravail jourTrav = ctx.getBean(IJourTravail.class);
		
		ISemaine        semaineService = ctx.getBean(ISemaine.class);
		Semaine semaine = new Semaine(new Date(), new Date()) ;
		semaineService.ajouterSemaine(semaine);
		jourTrav.ajouterJourTravail(new JourTravail(JourSemaine.DIMANCHE, new Date(), semaine));
		jourDis.ajouterJourDisponible(new JourDisponible(JourSemaine.JEUDI, new Date(),semaine ));
		jourDis.ajouterJourDisponible(new JourDisponible(JourSemaine.MARDI, new Date(),semaine ));
		jourDis.ajouterJourDisponible(new JourDisponible(JourSemaine.LUNDI, new Date(),semaine ));
		jourTrav.ajouterJourTravail(new JourTravail(JourSemaine.MERCREDI, new Date(), semaine));
		jourTrav.ajouterJourTravail(new JourTravail(JourSemaine.VENDREDI, new Date(), semaine));
		for (JourTravail jourTravail :jourTrav.allJoursTravail() ) {
			
			System.out.println(jourTravail.getJourSemaine());
			
		}
		
		for (JourDisponible jourDisponible :jourDis.allJoursDisponible() ) {
			
			System.out.println(jourDisponible.getJourSemaine());
			
		}
		
	}
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
