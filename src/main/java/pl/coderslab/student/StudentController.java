package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.mark.Mark;
import pl.coderslab.mark.MarkDao;
import pl.coderslab.schoolClass.SchoolClassDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentDao studentDao;
    private SchoolClassDao schoolClassDao;
    private MarkDao markDao;
    private StudentRepository studentRepository;
    public StudentController(StudentDao studentDao, SchoolClassDao schoolClassDao, MarkDao markDao){
        this.studentDao = studentDao;
        this.schoolClassDao = schoolClassDao;
        this.markDao = markDao;
    }
    @RequestMapping("/all")
    public String allStudents(Model model){
        List<Student> students = studentDao.allStudents();
        model.addAttribute("students", students);
        return "student/all";
    }

    @RequestMapping("/{id}")
    public String specificStudent(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        HttpSession sess = request.getSession();
        model.addAttribute("classId",sess.getAttribute("classId"));
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
    public String addStudentX(HttpServletRequest request){
        HttpSession session = request.getSession();
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setSchoolClass(schoolClassDao.specificClass(Long.parseLong(session.getAttribute("classId").toString())));
        studentDao.addStudent(student);
        return "redirect:/class/studentlist/" + session.getAttribute("classId");
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

    @GetMapping("/marks/{id}")
    public String studentMarks(@PathVariable Long id, Model model){
        List<Mark> marks = markDao.markList(id);
        model.addAttribute("marks", marks);
        return "student/marks";

    }

}
