package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepo;
import pl.coderslab.charity.conventer.CategoryConverter;
import pl.coderslab.charity.conventer.InstitutionConverter;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationRepo;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.print.DocFlavor;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Controller
public class FdsfController {
    CategoryRepo categoryRepo;
    InstitutionRepo institutionRepo;
    DonationRepo donationRepo;
    InstitutionConverter institutionConverter;
    CategoryConverter categoryConverter;

    public FdsfController(CategoryRepo categoryRepo, InstitutionRepo institutionRepo, DonationRepo donationRepo, InstitutionConverter institutionConverter, CategoryConverter categoryConverter) {
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
        this.institutionConverter = institutionConverter;
        this.categoryConverter = categoryConverter;
    }

    @GetMapping("/form")
    public String getCategories(Model model) {
        model.addAttribute("donation", new Donation());
        return "formbinging";
    }

    @PostMapping("/form")
    public String postCategories(@ModelAttribute("donation")@Valid Donation donation, BindingResult result) {

        if (result.hasErrors()){
            return "formbinging";
        }
        donationRepo.save(donation);
        return "form-confirmation";
    }
    @ModelAttribute("categories")
    public List<Category> getSomeCat(){


        List<Category>ala = categoryRepo.findAll();

        List<String>aa = categoryRepo.getAllNames();

        return ala;
    }
    @ModelAttribute("institutions")
    public List<Institution> getSomeIns(){

        List<Institution> lol = institutionRepo.findAll();

        List<String>institutionList = institutionRepo.getAllNames();

        return  lol;
    }

    @ModelAttribute("description")
    public List<String>descriptionOfCategory(){
        List<String>desc = new ArrayList<>();
        desc.add("ubrania, które nadają się do ponownego użycia");
        desc.add("ubrania, do wyrzucenia");
        desc.add("zabawki");
        desc.add("książki");
        desc.add("inne");
        return desc;

    }



    }