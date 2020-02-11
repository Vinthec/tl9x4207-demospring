package fr.cesi.poealtran.demospring.entities.localite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Représentation d'une région de France<br/>
 * <br/>
 * 
 * @author Clement ORTIZ
 *
 */
@Entity
public class Region extends Localite {

	@NotNull
	@ManyToOne
	private Nation nation;

	@OneToMany(mappedBy = "region", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private Set<Departement> departements = new HashSet<>();

	public Region(String nom, Nation nation) {
		super(nom);
		this.nation = nation;
	}

	Region() {
	}

	public Departement createDepartement(String numero, String nom) {
		Departement ret = new Departement(numero, nom, this);
		departements.add(ret);
		return ret;
	}

	public Set<Departement> getDepartements() {
		return new HashSet<>(departements);
	}

	public Nation getNation() {
		return nation;
	}

	@Override
	@JsonIgnore
	public String getNaturalKey() {
		return getNom();
	}

	@Override
	public String toString() {
		return "Region [id=" + getId() + ", nom=" + getNom() + "]";
	}
}
