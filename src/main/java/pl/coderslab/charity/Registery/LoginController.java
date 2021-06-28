package pl.coderslab.charity.Registery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String LoginSite(){
        return "login";
    }
}
