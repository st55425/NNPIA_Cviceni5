package cz.upce.nnpia_cv5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    private String password;

    private String firstName;

    private String surname;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    private Boolean blocked;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservation;

}
