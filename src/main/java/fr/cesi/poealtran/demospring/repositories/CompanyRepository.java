package fr.cesi.poealtran.demospring.repositories;

import fr.cesi.poealtran.demospring.entities.Company;
import fr.cesi.poealtran.demospring.entities.Contact;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// @Repository <=> @Component <=> @Bean (Bean Spring)
@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    // Query Methods => methods to JPQL then SQL
    // SELECT c FROM Contact WHERE c.name = ?1
    // SELECT * FROM contact WHERE lastname = ?1
    public Company findByName(String name);

}
