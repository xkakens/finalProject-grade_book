package pl.coderslab.schoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//michał
@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
