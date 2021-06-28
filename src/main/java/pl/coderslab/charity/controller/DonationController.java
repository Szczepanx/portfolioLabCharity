package pl.coderslab.charity.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepo;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationRepo;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepo;


import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
import java.util.Set;

@Controller
public class DonationController {

    CategoryRepo categoryRepo;
    InstitutionRepo institutionRepo;
    DonationRepo donationRepo;

    public DonationController(CategoryRepo categoryRepo, InstitutionRepo institutionRepo, DonationRepo donationRepo) {
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
    }


    @GetMapping("/form")
    public String getCategories(Model model){
         model.addAttribute("donation", new Donation());
         return "form";
    }

//    @PostMapping("/form")
//    public String postCategories(@RequestParam("categories") String[] categories, @RequestParam("bags") Integer bags,
//                                 @RequestParam("organization") String organization, @RequestParam("address") String address,
//                                 @RequestParam("city") String city , @RequestParam("postcode") String postcode,
//                                 @RequestParam("data") String data, @RequestParam("time") String time,
//                                 @RequestParam("more_info") String more_info , Model model){
//
//        Donation donation = new Donation(bags,categories,organization,address,city,postcode,data,time,more_info);
//        model.addAttribute("donation", donation);
//        donationRepo.save(donation);
//
//        return "form-confirmation";
//    }
    
    public List<Category> getSomeCat(){
        List<Category> categoryList = categoryRepo.findAll();
        return categoryList;
    }

    public List<Institution> getSomeIns(){
        List<Institution> institutionList = institutionRepo.findAll();
        return  institutionList;
    }

}
