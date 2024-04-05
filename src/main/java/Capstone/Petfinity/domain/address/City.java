package Capstone.Petfinity.domain.address;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
