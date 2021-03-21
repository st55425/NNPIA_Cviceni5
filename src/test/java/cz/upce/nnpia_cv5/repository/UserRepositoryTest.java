package cz.upce.nnpia_cv5.repository;

import cz.upce.nnpia_cv5.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsernameTest(){
        User user = repository.findAll().get(0);
        assertEquals(user, repository.findByUsername(user.getUsername()));
    }

}