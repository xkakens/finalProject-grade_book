package pl.coderslab.schoolClass;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SchoolClassDao {

    private final SchoolClassRepository schoolClassRepository;
    public SchoolClassDao(SchoolClassRepository schoolClassRepository){
        this.schoolClassRepository = schoolClassRepository;
    }
    public List<SchoolClass> schoolClassList(){
        return schoolClassRepository.findAll();
    }
}
