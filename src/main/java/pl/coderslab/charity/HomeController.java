package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationRepo;


@Controller
public class HomeController {

    DonationRepo donationRepo;

    public HomeController(DonationRepo donationRepo) {
        this.donationRepo = donationRepo;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("sumOfQuantity",donationRepo.findSumOfQuantity());
        model.addAttribute("numberOfDonations",donationRepo.findMaxId());
        return "index";
    }
}
