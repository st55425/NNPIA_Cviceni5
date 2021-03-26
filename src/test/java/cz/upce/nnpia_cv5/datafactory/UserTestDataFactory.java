package cz.upce.nnpia_cv5.datafactory;

import cz.upce.nnpia_cv5.entity.Court;
import cz.upce.nnpia_cv5.entity.CourtTypeEnum;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.entity.UserRoleEnum;
import cz.upce.nnpia_cv5.repository.CourtRepository;
import cz.upce.nnpia_cv5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTestDataFactory {

    public static final String DEFAULT_USERNAME = "test";
    public static final String DEFAULT_PASS = "pass";
    public static final boolean DEFAULT_BLOCKED = false;
    public static final String DEFAULT_FIRST_NAME = "Jiri";
    public static final String DEFAULT_SURNAME = "Tester";
    public static final UserRoleEnum DEFAULT_ROLE = UserRoleEnum.USER;

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        if (user.getUsername() == null) user.setUsername(DEFAULT_USERNAME);
        if (user.getPassword() == null) user.setPassword(DEFAULT_PASS);
        if (user.getBlocked() == null) user.setBlocked(DEFAULT_BLOCKED);
        if (user.getFirstName() == null) user.setFirstName(DEFAULT_FIRST_NAME);
        if (user.getSurname() == null) user.setSurname(DEFAULT_SURNAME);
        if (user.getRole() == null) user.setRole(DEFAULT_ROLE);
        userRepository.save(user);
        return user;
    }


}
