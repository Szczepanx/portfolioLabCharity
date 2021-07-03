package pl.coderslab.charity.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

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
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class DonationController {



    CategoryRepo categoryRepo;
    InstitutionRepo institutionRepo;
    DonationRepo donationRepo;
    InstitutionConverter institutionConverter;
    CategoryConverter categoryConverter;
    Category category = new Category();
    Donation donation = new Donation();

    public DonationController(CategoryRepo categoryRepo, InstitutionRepo institutionRepo, DonationRepo donationRepo, InstitutionConverter institutionConverter, CategoryConverter categoryConverter) {
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
        this.institutionConverter = institutionConverter;
        this.categoryConverter = categoryConverter;
    }

    @GetMapping("/for")
    public String getCategories(Model model){
         model.addAttribute("donation", new Donation());
         return "form";

    }


    @PostMapping("/for")
    public String postCategories(@RequestParam("categories") String[] categories, @RequestParam("bags") Integer bags,
                                 @RequestParam("organization") String organizationId, @RequestParam("address") String address,
                                 @RequestParam("city") String city , @RequestParam("postcode") String postcode,
                                 @RequestParam("data") String data, @RequestParam("time") String time,
                                 @RequestParam("more_info") String more_info , Model model){
        List <Category>categories1 = new ArrayList();
        for (String cat2: categories) {
            categories1.add(categoryConverter.convert(cat2));
        }

        Institution ins = institutionConverter.convert(organizationId);

        Donation donation = new Donation(bags,categories1,ins,address,city,postcode,data,time,more_info);
        model.addAttribute("donation", donation);
        donationRepo.save(donation);

        return "form-confirmation";
    }
    
    public List<Category> getSomeCat(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList;
    }

    public List<Institution> getSomeIns(){
        List<Institution> institutionList = institutionRepo.findAll();
        return  institutionList;
    }



}
