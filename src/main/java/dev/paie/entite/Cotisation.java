package dev.paie.entite;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotisation")
public class Cotisation {
	@Id
	private Integer id;
	@Column(name = "code", length = 30)
	private String code;
	@Column(name = "libelle", length = 30)
	private String libelle;
	@Column(name = "tauxSalarial", scale=2)
	private BigDecimal tauxSalarial;
	@Column(name = "tauxPatronal", scale=2)
	private BigDecimal tauxPatronal;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
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
            if (obj instanceof Cotisation){
            	Cotisation coti = (Cotisation)obj;
                return (this.id==coti.getId()&&this.code.equals(coti.getCode()));
            }
        return false;
        }
		return false;
        }

}
