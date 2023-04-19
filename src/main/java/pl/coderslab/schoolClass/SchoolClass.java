package pl.coderslab.schoolClass;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.teacher.Teacher;

import javax.persistence.*;
//michał
@Entity
@Getter
@Setter
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Teacher tutor;

}
