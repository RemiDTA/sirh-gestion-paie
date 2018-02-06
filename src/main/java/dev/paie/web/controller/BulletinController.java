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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;

@Controller
@RequestMapping("/bulletin")
public class BulletinController {

	@PersistenceContext
	private EntityManager em;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerBulletin");
		// Recuperation des periodes et des RemunerationEmploye
		List<RemunerationEmploye> listEmp = em.createQuery("SELECT e FROM RemunerationEmploye e", RemunerationEmploye.class).getResultList();
		List<Periode> listPer = em.createQuery("SELECT p FROM Periode p", Periode.class).getResultList();

		// Insertion dans le formulaire afin d'allimenter les select
		mv.addObject("emp", listEmp);
		mv.addObject("per", listPer);

		BulletinSalaire bulletin = new BulletinSalaire();
		mv.addObject("bulletin", bulletin);

		return mv;
	}
	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmploye(@ModelAttribute("bulletin") BulletinSalaire bulletin ) {
		//insertion du bulletin qui a été saisit par l'utilisateur
		bulletin.setDateCreation(LocalDate.now());
		em.persist(bulletin);
		return "redirect:lister";
	}
	@Transactional
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView ListerBulletin() {
		List<BulletinSalaire> listBull = em.createQuery("SELECT b FROM BulletinSalaire b", BulletinSalaire.class).getResultList();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerBulletin");
		mv.addObject("bulletins", listBull);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/visualiser")
	@Transactional
	public ModelAndView visualiserBulletin(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/visualiserBulletin");
		// Recuperation du bulletin passé en paramètre
		BulletinSalaire bulletin = em.find(BulletinSalaire.class, id);
		
		//Rq : le bulletin retourner de base ne recupere que les relation 1-1 avec les autres tables => bulletin ne va pas juqu'au cotisation
		
		//Astuce : forcer le controleur a aller jusqu'aux cotisations
		bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables().iterator().next();
		bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables().iterator().next();
		mv.addObject("bulletin", bulletin);
		return mv;
	}
}
