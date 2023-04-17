package pl.coderslab.schoolClass;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/class")
@Controller
public class SchoolClassController {
    private final SchoolClassDao schoolClassDao;

    public SchoolClassController(SchoolClassDao schoolClassDao){
        this.schoolClassDao = schoolClassDao;
    }
    @RequestMapping("/list")
    public String userHome(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes",classes);
        return "class/all";
    }
}
