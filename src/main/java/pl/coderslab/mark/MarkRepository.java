package pl.coderslab.mark;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.student.Student;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByStudent(Student s);
}
