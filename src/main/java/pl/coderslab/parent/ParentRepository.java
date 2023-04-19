package pl.coderslab.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//michał
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
