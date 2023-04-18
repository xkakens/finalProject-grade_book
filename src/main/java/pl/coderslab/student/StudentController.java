package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.mark.MarkDao;
import pl.coderslab.mark.Mark;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentDao studentDao;
    private final MarkDao markDao;

    public StudentController(StudentDao studentDao, MarkDao markDao){
        this.markDao = markDao;
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
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = s.getDateOfBirth();
        String age = String.valueOf(Period.between(dateOfBirth, today).getYears());
        model.addAttribute("age", age);
        return "student/specific";
    }

    @GetMapping("/add")
    public String addStudent(){
        return "student/add";
    }

    @PostMapping("/add")
    public String addStudent(HttpServletRequest request){
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
        studentDao.addStudent(student);
        return "redirect:all";
    }

    @GetMapping("/remove/{id}")
    public String removeStudent(@PathVariable  Long id){
        studentDao.removeStudent(id);
        return "student/remove";
    }
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model){
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        return "student/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,HttpServletRequest request){
        Student s = studentDao.specificStudent(id);
        s.setFirstName(request.getParameter("firstName"));
//        s.setLastName();
        studentDao.updateStudent(id);
        return "redirect:all";
    }

    @GetMapping("/marks/{id}")
    public String studentMarks(@PathVariable Long id, Model model){
        List<Mark> marks = markDao.markList(id);
        Student s = studentDao.specificStudent(id);
        model.addAttribute("student", s);
        model.addAttribute("marks", marks);
        return "student/marks";
    }
}
