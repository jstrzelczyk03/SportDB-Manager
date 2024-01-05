package bdbt_bada_project.SpringApplication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "TRENERZY")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_TRENERA", nullable = false)
    private Integer trainerId;

    @Column(name = "IMIE", nullable = false)
    private String name;

    @Column(name = "NAZWISKO", nullable = false)
    private String surname;

    @Column(name = "DATA_URODZENIA", nullable = false)
    private String birthDate;

    @Column(name = "PESEL", nullable = false, length = 11)
    private String pesel;

    @Column(name = "PLEC", nullable = false)
    private String sex;

    @Column(name = "NR_KONTA")
    private String accountNumber;

    @Column(name = "DATA_ZATRUDNIENIA", nullable = false)
    private String hireDate;

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
        if (!(o instanceof Trainer)) return false;
        Trainer other = (Trainer) o;
        return trainerId != null && trainerId.equals(other.getTrainerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId);
    }
}
