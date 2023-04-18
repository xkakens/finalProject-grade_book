package pl.coderslab.schoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.student.Student;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
