package pl.coderslab.charity.Registery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String usersite(){
        return "user";
    }
}
