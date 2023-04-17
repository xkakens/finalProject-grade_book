package pl.coderslab.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.schoolClass.SchoolClass;
import pl.coderslab.schoolClass.SchoolClassDao;
import pl.coderslab.schoolClass.SchoolClassRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@Controller
public class LoginController {
    private final SchoolClassDao schoolClassDao;

    private SchoolClassRepository schoolClassRepository;
    public LoginController(SchoolClassDao schoolClassDao, SchoolClassRepository schoolClassRepository){
        this.schoolClassDao = schoolClassDao;
        this.schoolClassRepository = schoolClassRepository;
    }
    @GetMapping("/login")
    public String login(){
        return "redirect:/userHome";
    }
    @RequestMapping("/userHome")
    public String userHome(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes",classes);
        return "userHome";
    }
}
