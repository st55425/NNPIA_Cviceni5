import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.Creator
import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.repository.CourtRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = NnpiaCviceni4Application.class)
@Import(Creator.class)
class CourtRepositoryGroovyTest {

    @Autowired
    CourtRepository repository;

    @Autowired
    Creator creator;

    @Test
    void findByUsernameTest(){
        String courtName = "Kurt 2"
        creator.saveEntity(new Court(name: courtName));
        Court actual = repository.findByName(courtName);
        assertEquals(courtName, actual.getName());
    }

}