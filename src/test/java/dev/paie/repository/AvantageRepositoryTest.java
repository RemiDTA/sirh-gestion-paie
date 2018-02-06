package dev.paie.repository;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
//test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

@Autowired
private AvantageRepository aRepo;
@Test
public void test_sauvegarder_lister_mettre_a_jour() {

	aRepo.deleteAll();
	Avantage a=new Avantage();
	a.setCode("avantage1");
	a.setId(1);
	a.setMontant(new BigDecimal("1528.69"));
	a.setNom("nomAvantage");
	aRepo.save(a);
	Avantage Avan= aRepo.findOne(1);
	assertTrue(Avan.getId()== 1);
	a.setCode("avantage2");
	aRepo.save(a);
	Avan= aRepo.findOne(1);
	Avantage avan2=new Avantage();
	avan2 = aRepo.findByCode(Avan.getCode());
	assertTrue(Avan.equals(avan2));

}
}