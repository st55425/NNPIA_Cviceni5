package cz.upce.nnpia_cv5.service;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.TrainingUnit;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.repository.ReservationRepository;
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final TrainingUnitRepository trainingUnitRepository;

    @Override
    public Map<Reservation, Map<Court, List<TrainingUnit>>> getUsersReservations(User user){
        List<Reservation> reservations = reservationRepository.findAllUserReservation(user);
        Map<Reservation, Map<Court, List<TrainingUnit>>> sortedReservations = new HashMap<>();
        for (Reservation reservation: reservations) {
            sortedReservations.put(reservation, getSortedReservation(reservation.getTrainingUnits()));
        }
        return sortedReservations;
    }

    @Override
    public Map<Court, List<TrainingUnit>> getSortedReservation(List<TrainingUnit> units){
        Map<Court, List<TrainingUnit>> courts = new HashMap<>();
        for (var unit: units) {
            var court = courts.get(unit.getCourt());
            if (court == null){
                court = new ArrayList<>();
                courts.put(unit.getCourt(), new ArrayList<>());
            }
            if (!court.contains(unit)){
                court.add(unit);
            }
            courts.put(unit.getCourt(), court);
        }
        return courts;
    }

    @Override
    public void removeReservation(Long id){
        Reservation reservation = reservationRepository.findById(id).get();
        for (TrainingUnit unit:reservation.getTrainingUnits()) {
            unit.setReservation(null);
            trainingUnitRepository.save(unit);
        }
        reservationRepository.delete(reservation);
    }
}
