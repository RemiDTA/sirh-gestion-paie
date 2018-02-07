package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name = "nomUtilisateur", length = 100)
	private String nomUtilisateur;
	@Column(name = "motDePasse", length = 100)
	private String motDePasse;
	@Type(type="true_false")
	@Column(name ="estActif")
	private Boolean estActif;
	@Enumerated(EnumType.STRING)
	private ROLES role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getEstActif() {
		return estActif;
	}

	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	public ROLES getRole() {
		return role;
	}

	public void setRole(ROLES role) {
		this.role = role;
	}

}