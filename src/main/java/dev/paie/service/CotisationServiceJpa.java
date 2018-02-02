package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;




@Service
public class CotisationServiceJpa implements CotisationService {
@PersistenceContext private EntityManager em;


@Transactional
@Override
public void sauvegarder(Cotisation nouvelleCotisation) {
	// TODO Auto-generated method stub
	em.persist(nouvelleCotisation);
	
}

@Override
public void mettreAJour(Cotisation cotisation) {
	// TODO Auto-generated method stub
	
	
}


@Override
public List<Cotisation> lister() {
	List<Cotisation> cot = em.createQuery("select c from Cotisation c", Cotisation.class).getResultList();
	return cot;
}
}