package pl.coderslab.student;

import org.springframework.stereotype.Repository;
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
}
