package cz.upce.nnpia_cv5.service;

import cz.upce.nnpia_cv5.dto.UserDto;
import cz.upce.nnpia_cv5.entity.TrainingUnit;
import cz.upce.nnpia_cv5.entity.User;
import cz.upce.nnpia_cv5.entity.UserRoleEnum;
import cz.upce.nnpia_cv5.repository.TrainingUnitRepository;
import cz.upce.nnpia_cv5.repository.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@Getter
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingUnitRepository trainingUnitRepository;

    private User user;
    private final List<TrainingUnit> toReservation;

    public UserServiceImpl(){
        toReservation = new ArrayList<>();
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void addUnitToReservation(Long id){
        TrainingUnit unit = trainingUnitRepository.findById(id).get();
        if (!toReservation.contains(unit)) {
            toReservation.add(unit);
        }
    }

    @Override
    public void removeUnitReservation(Long id){
        TrainingUnit unit = trainingUnitRepository.getOne(id);
        toReservation.remove(unit);
    }

    @Override
    public boolean loginUser(UserDto userLoginDto){
        User login = userRepository.findByUsername(userLoginDto.getUsername());
        if (login != null){
            if (login.getPassword().equals(userLoginDto.getPassword())){
                user = login;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null){
            return false;
        }
        User newUser = new User();
        newUser.setBlocked(false);
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.setFirstName(userDto.getFirstName());
        newUser.setSurname(userDto.getSurname());
        newUser.setRole(UserRoleEnum.USER);
        userRepository.save(newUser);
        user = newUser;
        return true;
    }
}
