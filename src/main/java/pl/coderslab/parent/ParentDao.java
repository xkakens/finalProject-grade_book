package pl.coderslab.parent;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ParentDao {
    private final ParentRepository parentRepository;
    public ParentDao(ParentRepository parentRepository){
        this.parentRepository = parentRepository;
    }
    public void addParent(Parent parent){

    }
}
