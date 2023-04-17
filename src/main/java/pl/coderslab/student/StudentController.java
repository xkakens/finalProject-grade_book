package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Period;
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

    @GetMapping("/{id}")
    public String specificStudent(@PathVariable Long id, Model model){
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = s.getDateOfBirth();
        String age = Period.between(dateOfBirth, today).toString();
        model.addAttribute("age", age);
        return "student/specific";
    }

    @GetMapping("/add")
    public String addStudent(Student student){
        student.setFirstName("First name");
        student.setLastName("Last name");
        studentDao.addStudent(student);
        return "student/all";
    }

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable  Long id){
        studentDao.removeStudent(id);
        return "student/remove";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id){
        Student s = studentDao.specificStudent(id);
        s.setFirstName("updated first name");
        s.setLastName("updated last name");
        return "student/all";
    }

}
