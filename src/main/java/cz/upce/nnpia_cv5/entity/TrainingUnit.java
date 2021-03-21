package cz.upce.nnpia_cv5.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter @Setter
public class TrainingUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_from")
    private LocalDateTime from;

    @Column(name = "time_to")
    private LocalDateTime to;

    @ManyToOne
    private Court court;

    @ManyToOne
    private Reservation reservation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainingUnit)) return false;
        TrainingUnit that = (TrainingUnit) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
