package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentDao studentDao;
    private StudentRepository studentRepository;
    public StudentController(StudentDao studentDao){
        this.studentDao = studentDao;
    }
    @RequestMapping("/all")
    public String allStudents(Model model){
        List<Student> students = studentDao.allStudents();
        model.addAttribute("students", students);
        return "student/all";
    }

    @RequestMapping("/{id}")
    public String specificStudent(@PathVariable("id") Long id, Model model){
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        return "student/specific";
    }

}
