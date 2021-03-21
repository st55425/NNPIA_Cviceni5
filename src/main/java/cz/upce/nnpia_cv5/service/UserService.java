package cz.upce.nnpia_cv5.service;

import cz.upce.nnpia_cv5.dto.UserDto;
import cz.upce.nnpia_cv5.entity.User;

public interface UserService {
    void setUser(User user);

    void addUnitToReservation(Long id);

    void removeUnitReservation(Long id);

    boolean loginUser(UserDto userLoginDto);

    boolean createUser(UserDto userDto);

    User getUser();

    java.util.List<cz.upce.nnpia_cv5.entity.TrainingUnit> getToReservation();
}
