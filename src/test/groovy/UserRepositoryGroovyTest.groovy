import cz.upce.nnpia_cv5.NnpiaCviceni4Application
import cz.upce.nnpia_cv5.datafactory.UserTestDataFactory
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = NnpiaCviceni4Application.class)
@Import(UserTestDataFactory.class)
class UserRepositoryGroovyTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserTestDataFactory userTestDataFactory;

    @Autowired
    UserRepository repository;

    @Test
    void findByUsernameTest(){
        String testUsername = "test";
        userTestDataFactory.saveUser(new User(username: testUsername))
        User actual = repository.findByUsername(testUsername);
        assertEquals(testUsername, actual.getUsername());
    }

}