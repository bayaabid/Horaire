package com.horaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.horaire.model.JourDisponible;
import com.horaire.service.IJourDisponible;

@Controller
public class JourDisponibleController {
	
	@Autowired
	IJourDisponible iJourDisponible ;

	public JourDisponibleController() {
		super();
	}
	
	@RequestMapping(value="/jour/disponible",method = RequestMethod.GET)
    public String date(Model model){
		/*SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		String date1 ="02/01/1974";
		try {
			date = formater.parse(date1);
			System.out.println(date);
			
			} catch (ParseException e) {
			e.printStackTrace();

			}*/
		
		List<JourDisponible> jourDisponibles = iJourDisponible.allJoursDisponible();
		model.addAttribute("joursDisponibles",jourDisponibles );
    	return "jourDisponible-list";
    }

}
