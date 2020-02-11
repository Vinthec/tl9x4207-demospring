package fr.cesi.poealtran.demospring.entities.localite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nation extends Localite {

	@OneToMany(mappedBy = "nation", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private Set<Region> regions = new HashSet<>();

	public Nation(String nom) {
		super(nom);
	}

	Nation() {
	}

	public Region createRegion(String nom) {
		Region ret = new Region(nom, this);
		regions.add(ret);
		return ret;
	}

	public Set<Region> getRegions() {
		return new HashSet<>(regions);
	}

	@Override
	@JsonIgnore
	public String getNaturalKey() {
		return getNom();
	}

	@Override
	public String toString() {
		return "Nation [id=" + getId() + ", nom=" + getNom() + "]";
	}

}
