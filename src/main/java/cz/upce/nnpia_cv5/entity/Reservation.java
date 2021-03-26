package cz.upce.nnpia_cv5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean confirmed;

    @ManyToOne(optional = false)
    private User user;

    @OneToMany(mappedBy = "reservation")
    private List<TrainingUnit> trainingUnits;
}
