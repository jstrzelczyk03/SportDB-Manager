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
@Table(name = "OBIEKTY")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NR_OBIEKTU", nullable = false)
    private Integer placeId;

    @Column(name = "NAZWA_OBIEKTU", nullable = false)
    private String placeName;

    @Column(name = "POWIERZCHNIA", nullable = false)
    private Integer area;

    @Column(name = "LICZBA_MIEJSC", nullable = false)
    private Integer seatsNumber;

    @Column(name = "LICZBA_SZATNI")
    private Integer lockerRoomNumber;

    @Column(name = "LICZBA_TOALET")
    private Integer toiletNumber;

    @Column(name = "ZADASZENIE", nullable = false)
    private String roof;

    @ManyToOne
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Address address;


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Place)) return false;
        Place other = (Place) o;
        return placeId != null && placeId.equals(other.getPlaceId());
    }

    @Override
    public int hashCode(){return Objects.hash(placeId);
    }




}
