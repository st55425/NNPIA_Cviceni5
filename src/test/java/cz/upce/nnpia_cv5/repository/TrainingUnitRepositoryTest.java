package cz.upce.nnpia_cv5.repository;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.TrainingUnit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrainingUnitRepositoryTest {

    @Autowired
    CourtRepository courtRepository;

    @Autowired
    TrainingUnitRepository repository;

    @Test
    void findByUsernameTest(){
        Court court = courtRepository.findAll().get(0);
        List<TrainingUnit> units = repository.findByCourtAndFromBetween(court,
                LocalDateTime.of(2021, 4,1,0,0),
                LocalDateTime.of(2021, 4,30,0,0));
        assertTrue(units.size() >0);
    }

    @Test
    void findByReservationNotNullAndCourt() {
        Court court = courtRepository.findAll().get(0);
        List<TrainingUnit> units = repository.findByReservationNotNullAndCourt(court);
        assertTrue(units.size() >0);
    }
}