package fr.cesi.poealtran.demospring.entities.localite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departement extends Localite {

	@Column(unique = true)
	private String numero;

	@NotNull
	@ManyToOne
	private Region region;

	Departement() {
	} // ORM

	public Departement(String numero, String nom, Region region) {
		super(nom);
		this.numero = numero;
		this.region = region;
	}

	@Override
	public String toString() {
		return "Departement [numero=" + numero + ", region=" + region + ", getNom()=" + getNom() + "]";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Region getRegion() {
		return region;
	}

	@Override
	@JsonIgnore
	public String getNaturalKey() {
		return getNumero();
	}
}
