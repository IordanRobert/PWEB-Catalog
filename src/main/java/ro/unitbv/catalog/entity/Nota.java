package ro.unitbv.catalog.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Note")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "materie")
    private String materie;
    @Column(name = "nota")
    private int nota;
}
