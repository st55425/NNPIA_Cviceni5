package cz.upce.nnpia_cv5.repository;

import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    ReservationRepository repository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findAllUserReservation() {
        User user = userRepository.findByUsername("user1");
        List<Reservation> reservations = repository.findAllUserReservation(user);
        assertTrue(reservations.size()>0);
        assertTrue(reservations.get(0).getTrainingUnits().size() > 0);
    }
}