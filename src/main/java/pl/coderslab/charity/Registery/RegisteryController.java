package pl.coderslab.charity.Registery;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.ConstructorResult;

@Controller
public class RegisteryController {

    UsersRepository usersRepository;

    public RegisteryController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/register")
    public String registationMapping(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String registrationToEntity(@RequestParam String email,@RequestParam String password,@RequestParam String password2,
                                       @RequestParam String name, @RequestParam String lastName){
        if (password.equals(password2)){
            Users users = new Users(name,lastName,email,BCrypt.hashpw(password,BCrypt.gensalt()));
            usersRepository.save(users);
        }
        else{
            return "register";
        }
        return "redirect:/login";
    }


}
