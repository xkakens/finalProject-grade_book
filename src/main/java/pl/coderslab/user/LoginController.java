package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//bartek
@RequestMapping("")
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "redirect:/userHome";
    }

}
