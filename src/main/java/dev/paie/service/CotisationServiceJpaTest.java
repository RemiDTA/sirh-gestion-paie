package dev.paie.service;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;



//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired
	private CotisationService cotisationService;

@Test
public void test_sauvegarder_lister_mettre_a_jour() {
	Cotisation c= new Cotisation();
	c.setCode("c1");
	c.setId(1);
	c.setLibelle("cotisation1");
	c.setTauxPatronal(new BigDecimal("10.47"));
	c.setTauxSalarial(new BigDecimal("10.87"));
	
	cotisationService.sauvegarder(c);
	List<Cotisation> listCoti=cotisationService.lister();
	assertThat(listCoti, hasItem(c));
	
	c.setLibelle("cotisation2");
	cotisationService.mettreAJour(c);
	assertThat(listCoti, hasItem(c));

}
}