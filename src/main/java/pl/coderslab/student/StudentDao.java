package pl.coderslab.student;

import org.springframework.stereotype.Repository;
import pl.coderslab.schoolClass.SchoolClassDao;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class StudentDao {
    private final StudentRepository studentRepository;

    public StudentDao(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> allStudents(){
        return studentRepository.findAll();
    }
    public Student specificStudent(Long id){
        Optional<Student> optStudent = studentRepository.findById(id);
        return optStudent.orElse(null);
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void removeStudent(Long id){
        Student s = specificStudent(id);
        studentRepository.delete(s);
    }

    public void updateStudent(Long id){
        Student s = specificStudent(id);
        studentRepository.save(s);

    }

    public List<Student> classStudents(Long id){
        return studentRepository.findStudentsBySchoolClassId(id);
    }

}