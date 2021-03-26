import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.ReservationTestDataFactory
import cz.upce.nnpia_cv5.datafactory.UserTestDataFactory
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.repository.ReservationRepository;
import cz.upce.nnpia_cv5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = NnpiaCviceni4Application.class)
@Import([UserTestDataFactory.class, ReservationTestDataFactory.class])
class ReservationRepositoryGroovyTest {

    @Autowired
    ReservationRepository repository;

    @Autowired
    ReservationTestDataFactory reservationTestDataFactory;

    @Test
    void findAllUserReservation() {
        User user = reservationTestDataFactory.saveReservation(new Reservation()).getUser();
        List<Reservation> reservations = repository.findAllUserReservation(user);
        assertTrue(reservations.size()>0);
        assertEquals(reservations.get(0).getUser(), user);
    }
}