package pl.coderslab.student;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.klasa.Klasa;
import pl.coderslab.mark.Mark;
import pl.coderslab.parent.Parent;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @OneToOne
    private Parent firstParent;
    @OneToOne
    private Parent secondParent;
    @ManyToOne
    private Klasa klasa;
    @OneToMany
    private List<Mark> marks;
}
