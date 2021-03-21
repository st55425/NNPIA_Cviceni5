package cz.upce.nnpia_cv5.service;

import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.repository.ReservationRepository;
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final ReservationRepository reservationRepository;
    private final TrainingUnitRepository trainingUnitRepository;
    private final UserService userService;


    @Override
    public void saveReservation(){
        Reservation reservation = new Reservation();
        reservation.setConfirmed(true);
        reservation.setUser(userService.getUser());
        reservationRepository.save(reservation);
        for (var unit: userService.getToReservation()) {
            unit.setReservation(reservation);
            trainingUnitRepository.save(unit);
        }
        userService.getToReservation().clear();
    }
}
