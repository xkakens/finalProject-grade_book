package pl.coderslab.klasa;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.teacher.Teacher;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Klasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Teacher tutor;

}
