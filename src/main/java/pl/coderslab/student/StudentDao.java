package pl.coderslab.student;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

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
        return studentRepository.getOne(id);
    }
}
