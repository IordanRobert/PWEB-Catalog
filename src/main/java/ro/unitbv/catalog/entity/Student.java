package ro.unitbv.catalog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Studenti")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "nume_student")
    private String numeStudent;
    @Column(name = "prenume_student")
    private String prenumeStudent;
    @Column(name = "email")
    private String email;
    @Column(name = "telefon")
    private String telefon;

    private String getNumePrenume() {
        return this.numeStudent + " " + this.prenumeStudent;
    }
}
