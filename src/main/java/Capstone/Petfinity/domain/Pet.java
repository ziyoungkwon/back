package Capstone.Petfinity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class Pet {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "pet_id")
    private UUID pet;

    private String name;
    private LocalDateTime birth;
    private String gender;
    private String kind;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
