package pl.coderslab.charity.Registery;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    UsersRepository usersRepository;

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/login")
    public String LoginSite(){
        return "login";
    }
    @PostMapping("/login")
    public String LoGinForm(@RequestParam String email,@RequestParam String password){
        Users a = usersRepository.findByEmail(email);
        String saltedPass = a.getPassword();
        if (BCrypt.checkpw(password, saltedPass)){
            return "user";
        }
        else{
            System.out.println("erd");
            return "login";
            }
    }
}
