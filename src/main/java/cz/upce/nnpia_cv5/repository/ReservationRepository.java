package cz.upce.nnpia_cv5.repository;

import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query("""
    select res from Reservation res
    left join fetch res.trainingUnits
    where res.user = :user
    """)
    List<Reservation> findAllUserReservation(User user);
}
