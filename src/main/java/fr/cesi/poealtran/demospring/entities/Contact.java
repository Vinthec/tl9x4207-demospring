package fr.cesi.poealtran.demospring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.cesi.poealtran.demospring.values.Couleur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

// @Entity => @Id + Bean JAVA
// Bean JAVA => class 1 constructeur par defaut + getters/setters
@Entity
@Table(name="contacts")
// @Data = @Getters + @Setters + @NoArgsConstructor
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    // int => type primitif
    // Integer => type objet, type wrappe
    // @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="lastname")
    // annotation from Jackson to personalize json format
    @JsonProperty("lastname")
    private String name;
    @Length(min=3, max=55)
    private String firstname;
    private String tel;
    @NaturalId
    @NotNull
    private String email;
     @ManyToOne
     private Company company;
     
     @Enumerated(EnumType.STRING)  //<-- fortement recommandé pour la maintenabilité // voir utiliser une entité
     private Type type;
     
    @OneToMany
    @OrderColumn
    private List<Adresse> adresses;
    
    @OneToMany
    @OrderBy("valeur desc")
    private List<Adresse> adresse2;
    
    @OneToMany
    @SortNatural
    private List<Adresse> adresse3;
    
    //private Couleur couleurPrefere;
    
    @ElementCollection
    private Set<Couleur> couleursChoisies;
    
    
    @ElementCollection
    private Map<Adresse, Double> adresseRating;
    
    @ElementCollection
    private Set<Qualification> adresses4;
    
    @ElementCollection
    private Map<Adresse,Qualification> adresses5;
    
    
    
    @Embeddable
    private class Qualification {
    	public Type type;
    	public Double rating;
    	
    	@ManyToOne
    	public Adresse adresse;
    }
    
    
}
