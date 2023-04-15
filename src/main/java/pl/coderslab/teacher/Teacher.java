package pl.coderslab.teacher;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.subject.Subject;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Subject> subjects;
}
