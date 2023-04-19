package pl.coderslab.student;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.mark.Mark;
import pl.coderslab.parent.Parent;
import pl.coderslab.schoolClass.SchoolClass;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
//michał
@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @OneToOne
    private Parent firstParent;
    @OneToOne
    private Parent secondParent;
    @ManyToOne
    private SchoolClass schoolClass;


}
