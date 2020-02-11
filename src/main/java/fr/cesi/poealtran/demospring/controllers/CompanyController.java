package fr.cesi.poealtran.demospring.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.poealtran.demospring.entities.Company;
import fr.cesi.poealtran.demospring.entities.Contact;
import fr.cesi.poealtran.demospring.services.CompanyService;
import fr.cesi.poealtran.demospring.services.ContactService;

// @RestController <=> @Component <=> @Bean
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

	@Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // URL /companys
    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(this.companyService.findAllCompanys(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(this.companyService.findCompanyById(id).get(), HttpStatus.OK);
    }
    
    @GetMapping("/v2/{id}")
    public Company getCompanyByIdV2(@PathVariable("id") Company company) {
        return company;
    }
    
    @PostMapping("/v2")
    public Contact test(@RequestBody Contact contact) {
        return contact;
    }
    
    
    
    @GetMapping("/{id}/contacts")
    public List<Contact> getContactFromCompany(@PathVariable Long id) {
        return this.companyService.getContactFromCompany(id);
    }
    
    

    @PostMapping
    public ResponseEntity<Company> postCompany(@RequestBody Company c) {
        return new ResponseEntity<>(this.companyService.saveCompany(c),
                HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Company> putCompany( @RequestBody Company c) {
        // if we don't specify an id, it will create a new company
        // if we don't want to allow creation on PUT
        // we need to check if company exist before update (to avoid creation)
        if(this.companyService.existsCompanyById(c.getId()))
            return new ResponseEntity<>(this.companyService.saveCompany(c),
                HttpStatus.OK);
        else
            return new ResponseEntity<>(c,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long id) {
        this.companyService.deleteCompanyById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    // simple way
    /*
    @DeleteMapping("/{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        this.companyService.deleteCompanyById(id);
    }
    */

}
