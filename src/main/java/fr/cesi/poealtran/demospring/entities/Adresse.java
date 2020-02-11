package fr.cesi.poealtran.demospring.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.common.collect.Comparators;

import fr.cesi.poealtran.demospring.entities.localite.Localite;
import lombok.Data;

@Data
@Entity
public class Adresse  implements Comparable<Adresse>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String valeur;
	
	@ManyToOne
	private Localite localite;

	public final static Comparator<Adresse> comparator = Comparator.comparing(Adresse::getValeur).thenComparing(Adresse::getId);
	
	@Override
	public int compareTo(Adresse o) {
		return comparator.compare(this, o);
	}
	
}
