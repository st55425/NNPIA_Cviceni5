import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.Creator
import cz.upce.nnpia_cv5.entity.Court

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
@Import(Creator.class)
class TrainingUnitRepositoryGroovyTest {

    @Autowired
    Creator creator;

    @Autowired
    TrainingUnitRepository repository;

    @Test
    void findByCourtAndFromBetweenTest(){
        Court court = ((TrainingUnit)creator.saveEntity(new TrainingUnit())).getCourt();
        List<TrainingUnit> units = repository.findByCourtAndFromBetween(court,
                LocalDateTime.now().minusHours(1),
                LocalDateTime.now());
        assertTrue(units.size() ==1);
        assertEquals(court, units.get(0).getCourt())
    }

    @Test
    void findByReservationNotNullAndCourt() {
        Court court = ((TrainingUnit)creator.saveEntity(
                new TrainingUnit())).getCourt();

        List<TrainingUnit> units = repository.findByReservationNotNullAndCourt(court);
        assertTrue(units.size() ==1);
        assertNotNull(units.get(0).getReservation())
    }
}