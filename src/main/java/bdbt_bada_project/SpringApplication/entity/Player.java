package bdbt_bada_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "ZAWODNICY")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_ZAWODNIKA", nullable = false)
    private Integer playerId;

    @Column(name = "IMIE", nullable = false)
    private String name;

    @Column(name = "NAZWISKO", nullable = false)
    private String surname;

    @Column(name = "DATA_URODZENIA", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "PLEC", nullable = false)
    private String sex;

    @Column(name = "DATA_DOLACZENIA", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    @Column(name = "TELEFON", nullable = false)
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Address address;

    @ManyToOne
    @JoinColumn(name = "NR_DYSCYPLINY", nullable = false)
    private Discipline discipline;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player other = (Player) o;
        return playerId != null && playerId.equals(other.getPlayerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }
}
