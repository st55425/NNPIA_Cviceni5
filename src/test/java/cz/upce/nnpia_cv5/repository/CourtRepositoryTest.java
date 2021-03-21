package cz.upce.nnpia_cv5.repository;

import cz.upce.nnpia_cv5.entity.Court;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourtRepositoryTest {

    @Autowired
    CourtRepository repository;

    @Test
    void findByUsernameTest(){
        Court court = repository.findByName("Kurt 1");
        assertEquals(court.getName(), "Kurt 1");
        assertTrue(court.getTrainingUnits().size() > 0);
    }

}