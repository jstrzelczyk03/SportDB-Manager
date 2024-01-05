package bdbt_bada_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "DYSCYPLINY")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_DYSCYPLINY")
    private Integer disciplineId;

    @Column(name = "NAZWA_DYSCYPLINY", nullable = false)
    private String disciplineName;

    @Column(name = "KATEGORIA", nullable = false)
    private String category;

    @Column(name = "OPIS")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;
        Discipline other = (Discipline) o;
        return disciplineId != null && disciplineId.equals(other.getDisciplineId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplineId);
    }
}
