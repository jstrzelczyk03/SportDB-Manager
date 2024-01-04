package bdbt_bada_project.SpringApplication;

import jdk.jfr.Category;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Dyscypliny")
public class Dyscyplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_DYSCYPLINY")
    private Integer nr_dyscypliny;

    @Column(name = "NAZWA_DYSCYPLINY", nullable = false)
    private String nazwa_dyscypliny;

    @Column(name = "KATEGORIA", nullable = false)
    private String kategoria;

    @Column(name = "OPIS")
    private String opis;

    public Dyscyplina() {
    }

    public Dyscyplina(Integer nr_dyscypliny, String nazwa_dyscypliny, String kategoria, String opis) {
        super();
        this.nr_dyscypliny = nr_dyscypliny;
        this.nazwa_dyscypliny = nazwa_dyscypliny;
        this.kategoria = kategoria;
        this.opis = opis;
    }

    public Integer getNr_dyscypliny() {
        return nr_dyscypliny;
    }

    public void setNr_dyscypliny(Integer nr_dyscypliny) {
        this.nr_dyscypliny = nr_dyscypliny;
    }

    public String getNazwa_dyscypliny() {
        return nazwa_dyscypliny;
    }

    public void setNazwa_dyscypliny(String nazwa_dyscypliny) {
        this.nazwa_dyscypliny = nazwa_dyscypliny;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Dyscyplina{" +
                "nr_dyscypliny=" + nr_dyscypliny +
                ", nazwa_dyscypliny='" + nazwa_dyscypliny + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

}
