package pl.coderslab.teacher;

import org.springframework.stereotype.Repository;
import pl.coderslab.mark.Mark;
import pl.coderslab.mark.MarkRepository;
import pl.coderslab.student.Student;
import pl.coderslab.student.StudentDao;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//xkakens
@Repository
@Transactional
public class TeacherDao {
    private final TeacherRepository teacherRepository;
    public TeacherDao(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher specificTeacher(Long id){
        Optional<Teacher> optTeacher = teacherRepository.findById(id);
        return optTeacher.orElse(null);
    }
    public List<Teacher> allTeachers(){
        return teacherRepository.findAll();
    }
}