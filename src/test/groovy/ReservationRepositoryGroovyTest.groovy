import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.Creator
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = NnpiaCviceni4Application.class)
@Import(Creator.class)
class ReservationRepositoryGroovyTest {

    @Autowired
    ReservationRepository repository;

    @Autowired
    Creator creator;

    @Test
    void findAllUserReservation() {
        User user = ((Reservation)creator.saveEntity(new Reservation())).getUser();
        List<Reservation> reservations = repository.findAllUserReservation(user);
        assertTrue(reservations.size() == 1);
        assertEquals(reservations.get(0).getUser(), user);
    }
}