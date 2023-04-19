package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//50/50
@Controller
public class HomeController {
    @RequestMapping("/")
    public String hello(){
        return "index";
    }

}
