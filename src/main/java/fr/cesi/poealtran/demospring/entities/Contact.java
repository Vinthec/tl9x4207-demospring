package fr.cesi.poealtran.demospring.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

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
    private String email;
    // @ManyToOne
    // private Company company
}
