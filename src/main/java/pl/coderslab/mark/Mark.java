package pl.coderslab.mark;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import pl.coderslab.student.Student;
import pl.coderslab.subject.Subject;

//michał

@Entity
@Getter
@Setter
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int importance;
    private int value;
    private String description;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private MarkType markType;
    @ManyToOne
    private Student student;
}
