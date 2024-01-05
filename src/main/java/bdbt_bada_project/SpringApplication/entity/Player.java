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
    private String birthDate;

    @Column(name = "PLEC", nullable = false)
    private String sex;

    @Column(name = "DATA_DOLACZENIA", nullable = false)
    private String joinDate;

    @Column(name = "TELEFON", nullable = false)
    private String phone;

    @Column(name = "EMAIL")
    private String email;



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
