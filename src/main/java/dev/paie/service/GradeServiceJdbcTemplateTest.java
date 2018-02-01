package dev.paie.service;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//TODO compléter la configuration
//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
// Configuration JUnit pour que Spring prenne la main sur le cycle de vie du
// test
@RunWith(SpringRunner.class)

public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		JdbcTemplate jdbcTemplate;
		// TODO sauvegarder un nouveau grade
		Grade grd = new Grade();
		grd.setCode("grade1");
		grd.setId(1);
		grd.setNbHeuresBase(new BigDecimal("1000"));
		grd.setTauxBase(new BigDecimal("10.54"));

		gradeService.sauvegarder(grd);
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode listera
		List<Grade> listGrade=gradeService.lister();
		assertThat(listGrade, hasItem(grd));
		
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	}
}