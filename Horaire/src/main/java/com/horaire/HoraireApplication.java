package com.horaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

import com.horaire.model.HeureDebutFin;
import com.horaire.model.JourDisponible;
import com.horaire.model.JourSemaine;
import com.horaire.model.JourTravail;
import com.horaire.model.Semaine;
import com.horaire.model.User;
import com.horaire.service.IHeureDebutFin;
import com.horaire.service.IJourDisponible;
import com.horaire.service.IJourTravail;
import com.horaire.service.ISemaine;
import com.horaire.service.IUserService;


@SpringBootApplication
public class HoraireApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HoraireApplication.class, args);
		
		IJourDisponible jourDis = ctx.getBean(IJourDisponible.class);
		IUserService userService = ctx.getBean(IUserService.class);
		IJourTravail jourTrav = ctx.getBean(IJourTravail.class);
		IHeureDebutFin debutFin = ctx.getBean(IHeureDebutFin.class);
		
		User user=userService.getUserByID(1L);
		ISemaine        semaineService = ctx.getBean(ISemaine.class);
		Semaine semaine = new Semaine(new Date(), new Date()) ;
		semaineService.ajouterSemaine(semaine);
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		String date1 ="02/01/1974";
		
		HeureDebutFin heureDebutFin =new HeureDebutFin();
		heureDebutFin.getHeures().add("9:00");heureDebutFin.getHeures().add("9:30");heureDebutFin.getHeures().add("10:00");
		heureDebutFin.getHeures().add("10:30");heureDebutFin.getHeures().add("11:00");heureDebutFin.getHeures().add("11:30");
		heureDebutFin.getHeures().add("12:00");heureDebutFin.getHeures().add("12:30");heureDebutFin.getHeures().add("13:00");
		heureDebutFin.getHeures().add("13:30");heureDebutFin.getHeures().add("14:00");heureDebutFin.getHeures().add("14:30");
		heureDebutFin.getHeures().add("15:00");heureDebutFin.getHeures().add("15:30");heureDebutFin.getHeures().add("16:00");
		heureDebutFin.getHeures().add("16:30");heureDebutFin.getHeures().add("17:00");heureDebutFin.getHeures().add("17:30");
		heureDebutFin.getHeures().add("18:00");heureDebutFin.getHeures().add("18:30");heureDebutFin.getHeures().add("19:00");
		heureDebutFin.getHeures().add("19:30");heureDebutFin.getHeures().add("20:00");heureDebutFin.getHeures().add("20:30");
		heureDebutFin.getHeures().add("21:00");heureDebutFin.getHeures().add("21:30");heureDebutFin.getHeures().add("22:00");
		heureDebutFin.getHeures().add("22:30");heureDebutFin.getHeures().add("23:00");heureDebutFin.getHeures().add("23:30");
		heureDebutFin.getHeures().add("24:00");heureDebutFin.getHeures().add("00:30");heureDebutFin.getHeures().add("1:00");
		heureDebutFin.getHeures().add("1:30");heureDebutFin.getHeures().add("2:00");heureDebutFin.getHeures().add("2:30");
		debutFin.ajouterHeureDebutFin(heureDebutFin);
		
		
		try {
			date = formater.parse(date1);
			System.out.println(date);
			
			} catch (ParseException e) {
			e.printStackTrace();

			}	
		
		
		
		JourDisponible jourDisponible1 =new JourDisponible(JourSemaine.JEUDI,date,semaine );
		jourDisponible1.getUsers().add(user);
		jourDisponible1.setHeureDebut(heureDebutFin.getHeures().get(0));
		jourDisponible1.setHeureFin(heureDebutFin.getHeures().get(21));
		jourDis.ajouterJourDisponible(jourDisponible1);
		
		JourTravail jourTravail1 = new JourTravail(JourSemaine.DIMANCHE, new Date(), semaine);
		jourTravail1.getUsers().add(user);
		jourTravail1.setHeureDebut(heureDebutFin.getHeures().get(1));
		jourTravail1.setHeureFin(heureDebutFin.getHeures().get(20));
		jourTrav.ajouterJourTravail(jourTravail1);
		
		
		
		JourDisponible jourDisponible2 = new JourDisponible(JourSemaine.MARDI, new Date(),semaine );
		jourDisponible2.getUsers().add(user);
		jourDisponible2.setHeureDebut(heureDebutFin.getHeures().get(1));
		jourDisponible2.setHeureFin(heureDebutFin.getHeures().get(20));
		jourDis.ajouterJourDisponible(jourDisponible2);
		
		JourDisponible jourDisponible3 = new JourDisponible(JourSemaine.LUNDI, new Date(),semaine );
		jourDisponible3.getUsers().add(user);
		jourDisponible3.setHeureDebut(heureDebutFin.getHeures().get(1));
		jourDisponible3.setHeureFin(heureDebutFin.getHeures().get(21));
		jourDis.ajouterJourDisponible(jourDisponible3);
		
		JourTravail jourTravail2 = new JourTravail(JourSemaine.MERCREDI, new Date(), semaine);
		jourTravail2.setHeureDebut(heureDebutFin.getHeures().get(1));
		jourTravail2.setHeureFin(heureDebutFin.getHeures().get(20));
		jourTrav.ajouterJourTravail(jourTravail2);
		
		JourTravail jourTravail3 = new JourTravail(JourSemaine.VENDREDI, new Date(), semaine);
		jourTravail3.setHeureDebut(heureDebutFin.getHeures().get(0));
		jourTravail3.setHeureFin(heureDebutFin.getHeures().get(21));
		jourTrav.ajouterJourTravail(jourTravail3);
		
		
		
		
		jourDisponible1.setFermeture(true);
		jourDis.updatejourDidponible(jourDisponible1);
		
		for (JourDisponible jourDisponible :jourDis.allJoursDisponible() ) {
			System.out.println(jourDisponible.getDateJour()+"////");
			System.out.println(jourDisponible.getHeureDebut()+"***************");
			System.out.println(jourDisponible.getHeureFin());
		}
		
	}
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}
