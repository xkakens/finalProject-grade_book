package pl.coderslab.mark;

import org.springframework.stereotype.Repository;
import pl.coderslab.student.Student;
import pl.coderslab.student.StudentDao;

import javax.transaction.Transactional;
import java.util.List;

//michał

@Repository
@Transactional
public class MarkDao {
    private final MarkRepository markRepository;
    private final StudentDao studentDao;

    public MarkDao(MarkRepository markRepository, StudentDao studentDao){
        this.markRepository = markRepository;
        this.studentDao = studentDao;
    }

    public List<Mark> markList(Long id){
        Student s = studentDao.specificStudent(id);
        return markRepository.findAllByStudent(s);
    }
}