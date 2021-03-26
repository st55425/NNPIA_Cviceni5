import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.CourtTestDataFactory
import cz.upce.nnpia_cv5.datafactory.ReservationTestDataFactory
import cz.upce.nnpia_cv5.datafactory.TrainingUnitTestDataFactory
import cz.upce.nnpia_cv5.datafactory.UserTestDataFactory
import cz.upce.nnpia_cv5.entity.Court
import cz.upce.nnpia_cv5.entity.Reservation;
import cz.upce.nnpia_cv5.entity.TrainingUnit
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertNotNull
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = NnpiaCviceni4Application.class)
@Import([TrainingUnitTestDataFactory.class, CourtTestDataFactory.class, ReservationTestDataFactory.class, UserTestDataFactory.class])
class TrainingUnitRepositoryGroovyTest {

    @Autowired
    TrainingUnitTestDataFactory trainingUnitTestDataFactory;

    @Autowired
    ReservationTestDataFactory reservationTestDataFactory;

    @Autowired
    TrainingUnitRepository repository;

    @Test
    void findByCourtAndFromBetweenTest(){
        Court court = trainingUnitTestDataFactory.saveTrainingUnit(new TrainingUnit()).getCourt();
        List<TrainingUnit> units = repository.findByCourtAndFromBetween(court,
                LocalDateTime.now().minusHours(1),
                LocalDateTime.now());
        assertTrue(units.size() ==1);
        assertEquals(court, units.get(0).getCourt())
    }

    @Test
    void findByReservationNotNullAndCourt() {
        Court court = trainingUnitTestDataFactory.saveTrainingUnit(
                new TrainingUnit(reservation: reservationTestDataFactory.
                        saveReservation(new Reservation()))).getCourt();

        List<TrainingUnit> units = repository.findByReservationNotNullAndCourt(court);
        assertTrue(units.size() ==1);
        assertNotNull(units.get(0).getReservation())
    }
}