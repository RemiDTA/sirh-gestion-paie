package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "avantage")
public class Avantage {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name = "code", length = 100)
	private String code;
	@Column(name = "nom", length = 100)
	private String nom;
	@Column(name = "montant", scale=2)
	private BigDecimal montant;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean equals (Object obj){
        if (obj!= null && (obj.getClass().equals(this.getClass()))){
            if (obj instanceof Avantage){
            	Avantage avan = (Avantage)obj;
                return (this.id==avan.getId()&&this.code.equals(avan.getCode()));
            }
        return false;
        }
		return false;
        }
}
