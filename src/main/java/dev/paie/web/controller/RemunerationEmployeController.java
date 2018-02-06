package dev.paie.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@PersistenceContext private EntityManager em;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		//Recuperation des entreprises profil et grade
		List<Entreprise> listEnt = em.createQuery("SELECT e FROM Entreprise e", Entreprise.class).getResultList();
		List<ProfilRemuneration> listprof = em.createQuery("SELECT p FROM ProfilRemuneration p", ProfilRemuneration.class).getResultList();
		List<Grade> listGrd = em.createQuery("SELECT g FROM Grade g", Grade.class).getResultList();
		
		//Insertion dans le formulaire afin d'allimenter les select
		mv.addObject("ent", listEnt);
		mv.addObject("prof", listprof);
		mv.addObject("grade", listGrd);
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		remunerationEmploye.setMatricule("M00");
		mv.addObject("remunerationEmploye", remunerationEmploye);
		
		return mv;
	}
	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmploye(@ModelAttribute("remunerationEmploye") RemunerationEmploye remunerationEmploye ) {
		//insertion de l'employé qui a été saisit par l'utilisateur
		remunerationEmploye.setDateCreation(LocalDate.now());
		em.persist(remunerationEmploye);
		return "redirect:lister";
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView ListerEmploye() {
		List<RemunerationEmploye> listEmp = em.createQuery("SELECT e FROM RemunerationEmploye e", RemunerationEmploye.class).getResultList();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("emp", listEmp);
		return mv;
	}
	
}