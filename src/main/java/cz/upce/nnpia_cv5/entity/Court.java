package cz.upce.nnpia_cv5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CourtTypeEnum type;

    private Boolean active;

    @OneToMany(mappedBy = "court")
    private List<TrainingUnit> trainingUnits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Court)) return false;
        Court court = (Court) o;
        return id.equals(court.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
