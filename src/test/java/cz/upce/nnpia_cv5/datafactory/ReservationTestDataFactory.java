package cz.upce.nnpia_cv5.datafactory;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.CourtTypeEnum;
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.repository.CourtRepository;
import cz.upce.nnpia_cv5.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationTestDataFactory {

    public static final boolean DEFAULT_Confirmed = true;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserTestDataFactory userTestDataFactory;

    public Reservation saveReservation(Reservation reservation){
        if (reservation.getConfirmed() == null) reservation.setConfirmed(true);
        if (reservation.getUser() == null) reservation.setUser(userTestDataFactory.saveUser(new User()));
        reservationRepository.save(reservation);
        return reservation;
    }


}
