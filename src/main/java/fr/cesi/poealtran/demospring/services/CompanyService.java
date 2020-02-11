package fr.cesi.poealtran.demospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.poealtran.demospring.entities.Company;
import fr.cesi.poealtran.demospring.entities.Contact;
import fr.cesi.poealtran.demospring.repositories.CompanyRepository;

// @Service <=> @Component <=> @Bean
@Service
public class CompanyService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private CompanyRepository companyRepo;

    
    // Dependency Injection
    @Autowired
    public CompanyService(CompanyRepository companyRepo) {
        this.companyRepo = companyRepo;
    }

    public List<Company> findAllCompanys() {
        // (CAST) Iterable<Company>
        return (List<Company>) companyRepo.findAll();
    }

    public Optional<Company> findCompanyById(Long id) {
        return this.companyRepo.findById(id);
    }

    public Company saveCompany(Company c) {
        return this.companyRepo.save(c);
    }

    public void deleteCompanyById(Long id) {
        this.companyRepo.deleteById(id);
    }

    public boolean existsCompanyById(Long id) {
        return this.companyRepo.existsById(id);
    }

	public List<Contact> getContactFromCompany(Long id) {
		Optional<Company> company = findCompanyById(id); 
		return null; //TODO
				
	}
}
