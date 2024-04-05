package Capstone.Petfinity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "parent_id")
    private UUID uuid;

    private String id;
    private String pw;
    private String name;
    private String phone_number;
    private Boolean login_status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "parent")
    private List<Pet> pets = new ArrayList<>();

    @OneToMany(mappedBy = "parent")
    private List<Reservation> reservations = new ArrayList<>();
}
