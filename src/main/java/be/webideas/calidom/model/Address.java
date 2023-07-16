package be.webideas.calidom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String postalCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    // Rest of the code...
}
