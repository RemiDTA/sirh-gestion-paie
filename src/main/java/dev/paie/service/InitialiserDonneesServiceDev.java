package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{



	@PersistenceContext private EntityManager em;


	@Transactional
	@Override
	public void initialiser() {
		
		//Initialisation des cotisations
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cotisations-imposables.xml", "cotisations-non-imposables.xml", "entreprises.xml", "grades.xml", "profils-remuneration.xml");

		Map<String, Cotisation> mapCoti = context.getBeansOfType(Cotisation.class);
		
		List<Cotisation> cotisationImpo=new ArrayList<Cotisation>(mapCoti.values());
		
		//Insertion en base

		for (Cotisation c: cotisationImpo)
		{
			em.persist(c);
		}
	
		//Initialisation des entreprises
		//context = new ClassPathXmlApplicationContext);

		Map<String, Entreprise> mapEnt = context.getBeansOfType(Entreprise.class);
		
		List<Entreprise> entreprises=new ArrayList<Entreprise>(mapEnt.values());

		//Insertion en base
		for (Entreprise e: entreprises)
		{
			em.persist(e);
		}
		
		//Initialisation des grades

		Map<String, Grade> mapGrades = context.getBeansOfType(Grade.class);
		
		List<Grade> grades=new ArrayList<Grade>(mapGrades.values());
		
		//Insertion en base
		for (Grade g: grades)
		{
			em.persist(g);
		}
		//Initialisation des profils remunérations

		Map<String, ProfilRemuneration> mapProfil = context.getBeansOfType(ProfilRemuneration.class);
		
		List<ProfilRemuneration> profils=new ArrayList<ProfilRemuneration>(mapProfil.values());
		
		//Insertion en base
		for (ProfilRemuneration p: profils)
		{
			em.persist(p);
		}
		context.close();
		
		//Creation des periodes
		LocalDate mtn = LocalDate.now();
		int annee = mtn.getYear();

		for (int mois=1; mois<=12; mois++){

			Periode p = new Periode();
			LocalDate debutP = LocalDate.of(annee, mois, 1);
			LocalDate finP = debutP.with(TemporalAdjusters.lastDayOfMonth());
			p.setDateDebut(debutP);
			p.setDateFin(finP);
			em.persist(p);
		}
	}

}
