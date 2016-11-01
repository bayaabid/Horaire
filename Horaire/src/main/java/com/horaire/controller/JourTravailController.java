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

import com.horaire.model.JourTravail;
import com.horaire.service.IJourTravail;

@Controller
@RequestMapping(value = "/jourTravail")
public class JourTravailController {

	@Autowired
	IJourTravail iJourTravail;

	@Autowired
	private MessageSource messageSource;

	public JourTravailController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listOfJourDisponible(Model model) {
		
		List<JourTravail> jourTravails = iJourTravail.allJoursTravail();
		model.addAttribute("joursTravails", jourTravails);

		if (!model.containsAttribute("jourTravail")) {
			JourTravail jourTravail = new JourTravail();
			model.addAttribute("jourTravail", jourTravail);
		}
		return "jourTravail-list";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingJourDisponible(@Valid @ModelAttribute JourTravail jourTravail, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.strategy", result);
			redirectAttributes.addFlashAttribute("jourDisponible", jourTravail);
			return "redirect:/jourTravail-list";
		} else {
			iJourTravail.ajouterJourTravail(jourTravail);
			String message = "jourDisponible" + jourTravail.getIdJour() + " was successfully added";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/jourTravail/list";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editStrategyPage(@RequestParam(value = "id", required = true) Long id, Model model) {

		if (!model.containsAttribute("jourDisponible")) {

			JourTravail jourTravail = iJourTravail.getJourTravailById(id);
						model.addAttribute("jourTravail", jourTravail);
		}

		return "jourTravail-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editingStrategy(@Valid @ModelAttribute JourTravail jourTravail, BindingResult result,
			RedirectAttributes redirectAttrs, @RequestParam(value = "action", required = true) String action) {

		if (action.equals(messageSource.getMessage("button.action.cancel", null, Locale.US))) {
			String message = "jourTravail" + jourTravail.getIdJour() + " edit cancelled";
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {

			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.jourTravail", result);
			redirectAttrs.addFlashAttribute("jourTravail", jourTravail);
			//return "redirect:/edit?id=" + jourTravail.getIdJour();
			return "jourTravail-edit";
		} else if (action.equals(messageSource.getMessage("button.action.save", null, Locale.US))) {
			
			iJourTravail.updatejourTravail(jourTravail);
			String message = "jourTravail" + jourTravail.getIdJour() + " was successfully edited";
			redirectAttrs.addFlashAttribute("message", message);
		}

		return "redirect:/jourTravail/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteStrategyPage(@RequestParam(value = "id", required = true) Long id,
			@RequestParam(value = "phase", required = true) String phase, Model model) {

		JourTravail jourTravail = iJourTravail.getJourTravailById(id);
		

		if (phase.equals(messageSource.getMessage("button.action.cancel", null, Locale.US))) {
			String message = "Strategy delete was cancelled.";
			model.addAttribute("message", message);
			return "redirect:/jourTravail/list";
		} else if (phase.equals(messageSource.getMessage("button.action.stage", null, Locale.US))) {
			String message = "jourDisponible" + jourTravail.getIdJour() + " queued for display.";
			model.addAttribute("jourTravail", jourTravail);
			model.addAttribute("message", message);
			return "jourTravail-delete";
		} else if (phase.equals(messageSource.getMessage("button.action.delete", null, Locale.US))) {
			iJourTravail.deleteJourTravail(jourTravail);;
			String message = "Strategy " + jourTravail.getIdJour() + " was successfully deleted";
			model.addAttribute("message", message);
			return "redirect:/jourTravail/list";
		}

		return "redirect:/jourTravail/list";
	}

}
