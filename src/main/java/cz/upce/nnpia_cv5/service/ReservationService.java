package cz.upce.nnpia_cv5.service;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.TrainingUnit;
import cz.upce.nnpia_cv5.entity.User;

import java.util.List;
import java.util.Map;

public interface ReservationService {
    Map<Reservation, Map<Court, List<TrainingUnit>>> getUsersReservations(User user);

    Map<Court, List<TrainingUnit>> getSortedReservation(List<TrainingUnit> units);

    void removeReservation(Long id);
}
