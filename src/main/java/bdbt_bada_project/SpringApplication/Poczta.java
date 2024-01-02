package bdbt_bada_project.SpringApplication;

public class Poczta {
    public Poczta(String kod_pocztowy, String miasto_poczty, int nr_poczty) {
        this.kod_pocztowy = kod_pocztowy;
        this.miasto_poczty = miasto_poczty;
        this.nr_poczty = nr_poczty;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nr_poczty=" + nr_poczty +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                ", miasto_poczty='" + miasto_poczty + '\'' +
                '}';
    }

    public int getNr_poczty() {
        return nr_poczty;
    }

    public void setNr_poczty(int nr_poczty) {
        this.nr_poczty = nr_poczty;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiasto_poczty() {
        return miasto_poczty;
    }

    public void setMiasto_poczty(String miasto_poczty) {
        this.miasto_poczty = miasto_poczty;
    }

    private int nr_poczty;
    private String kod_pocztowy;
    private String miasto_poczty;


}
