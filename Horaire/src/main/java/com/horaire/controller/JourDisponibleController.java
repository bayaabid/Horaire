package com.horaire.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.horaire.model.JourDisponible;
import com.horaire.service.IJourDisponible;

@Controller
@RequestMapping(value = "/jourDisponible")
public class JourDisponibleController {

	@Autowired
	IJourDisponible iJourDisponible;

	@Autowired
	private MessageSource messageSource;

	public JourDisponibleController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listOfJourDisponible(Model model) {
		/*
		 * SimpleDateFormat formater = null; formater = new
		 * SimpleDateFormat("dd/MM/yyyy"); Date date=null; String date1
		 * ="02/01/1974"; try { date = formater.parse(date1);
		 * System.out.println(date);
		 * 
		 * } catch (ParseException e) { e.printStackTrace();
		 * 
		 * }
		 */

		List<JourDisponible> jourDisponibles = iJourDisponible.allJoursDisponible();
		model.addAttribute("joursDisponibles", jourDisponibles);

		if (!model.containsAttribute("jourDisponible")) {
			JourDisponible jourDisponible = new JourDisponible();
			model.addAttribute("jourDisponible", jourDisponible);
		}
		return "jourDisponible-list";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingJourDisponible(@Valid @ModelAttribute JourDisponible jourDisponible, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.strategy", result);
			redirectAttributes.addFlashAttribute("jourDisponible", jourDisponible);
			return "redirect:/jourDisponible/list";
		} else {
			iJourDisponible.ajouterJourDisponible(jourDisponible);
			String message = "jourDisponible" + jourDisponible.getIdJour() + " was successfully added";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/jourDisponible/list";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editStrategyPage(@RequestParam(value = "id", required = true) Long id, Model model) {

		if (!model.containsAttribute("strategy")) {

			JourDisponible jourDisponible = iJourDisponible.getJourDisponibleById(id);

			model.addAttribute("jourDisponible", jourDisponible);
		}

		return "strategy-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editingStrategy(@Valid @ModelAttribute JourDisponible jourDisponible, BindingResult result,
			RedirectAttributes redirectAttrs, @RequestParam(value = "action", required = true) String action) {

		if (action.equals(messageSource.getMessage("button.action.cancel", null, Locale.US))) {
			String message = "jourDisponible" + jourDisponible.getIdJour() + " edit cancelled";
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {

			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.jourDisponible", result);
			redirectAttrs.addFlashAttribute("jourDisponible", jourDisponible);
			return "redirect://edit?id=" + jourDisponible.getIdJour();
		} else if (action.equals(messageSource.getMessage("button.action.save", null, Locale.US))) {

			iJourDisponible.updatejourDidponible(jourDisponible);
			String message = "jourDisponible" + jourDisponible.getIdJour() + " was successfully edited";
			redirectAttrs.addFlashAttribute("message", message);
		}

		return "redirect:/strategy/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStrategyPage(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "phase", required = true) String phase, Model model) {

		JourDisponible jourDisponible = iJourDisponible.getJourDisponibleById(id);
		

		if (phase.equals(messageSource.getMessage("button.action.cancel", null, Locale.US))) {
			String message = "Strategy delete was cancelled.";
			model.addAttribute("message", message);
			return "redirect:/strategy/list";
		} else if (phase.equals(messageSource.getMessage("button.action.stage", null, Locale.US))) {
			String message = "jourDisponible" + jourDisponible.getIdJour() + " queued for display.";
			model.addAttribute("jourDisponible", jourDisponible);
			model.addAttribute("message", message);
			return "strategy-delete";
		} else if (phase.equals(messageSource.getMessage("button.action.delete", null, Locale.US))) {
			iJourDisponible.deleteJourDisponible(jourDisponible);;
			String message = "Strategy " + jourDisponible.getIdJour() + " was successfully deleted";
			model.addAttribute("message", message);
			return "redirect:/strategy/list";
		}

		return "redirect:/strategy/list";
	}

}
