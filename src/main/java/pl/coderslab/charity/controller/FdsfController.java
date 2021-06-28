package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepo;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationRepo;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepo;

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

    public FdsfController(CategoryRepo categoryRepo, InstitutionRepo institutionRepo, DonationRepo donationRepo) {
        this.categoryRepo = categoryRepo;
        this.institutionRepo = institutionRepo;
        this.donationRepo = donationRepo;
    }

    @GetMapping("/lol")
    public String getCategories(Model model){
        model.addAttribute("donation", new Donation());
        return "fdsf";
    }

    @PostMapping("/lol")
    public String postCategories(@ModelAttribute("donation") Donation donation){
        donationRepo.save(donation);
        return "Zapisano";
    }
    @ModelAttribute("categories")
    public String[] getSomeCat(){
        List<Category> categoryList = categoryRepo.findAll();
        String[] aa= new String[5];
        for (Category a:categoryList) {
            aa[(int) (a.getId()-1)] = a.getName();
        }
        return aa;
    }
    @ModelAttribute("institutions")
    public List<Institution> getSomeIns(){
        List<Institution> institutionList = institutionRepo.findAll();
        return  institutionList;
    }



}
