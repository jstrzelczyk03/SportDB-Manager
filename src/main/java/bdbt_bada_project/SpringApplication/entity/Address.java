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
@Table(name = "ADRESY")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_ADRESU", nullable = false)
    private Integer addressId;

    @Column(name = "MIEJSCOWOSC", nullable = false)
    private String town;

    @Column(name = "ULICA", nullable = false)
    private String street;

    @Column(name = "NR_DOMU", nullable = false)
    private Integer houseNumber;

    @Column(name = "NR_LOKALU")
    private Integer apartmentNumber;

    @Column(name = "KOD_POCZTOWY", nullable = false)
    private String zipCode;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address other = (Address) o;
        return addressId != null && addressId.equals(other.getAddressId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}
