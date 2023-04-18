package pl.coderslab.schoolClass;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.student.Student;
import pl.coderslab.student.StudentDao;

import java.util.List;

@RequestMapping("/class")
@Controller
public class SchoolClassController {
    private final SchoolClassDao schoolClassDao;
    private final StudentDao studentDao;

    public SchoolClassController(SchoolClassDao schoolClassDao, StudentDao studentDao){
        this.schoolClassDao = schoolClassDao;
        this.studentDao = studentDao;
    }
    @RequestMapping("/list")
    public String userHome(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes",classes);
        return "class/all";
    }

    @GetMapping("/all")
    public String allClasses(Model model){
        List<SchoolClass> classes = schoolClassDao.schoolClassList();
        model.addAttribute("classes", classes);
        return "class/all";
    }
    @GetMapping("/studentlist/{id}")
    public String classStudents(@PathVariable Long id, Model model){
        List<Student> students = studentDao.classStudents(id);
        model.addAttribute("students", students);
        return "class/studentlist";
    }
}