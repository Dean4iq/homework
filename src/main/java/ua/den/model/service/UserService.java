package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.den.model.dto.UserDto;
import ua.den.model.entity.User;
import ua.den.model.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(UserDto userDto){
        User user = new User();

        if (checkLoginExistence(userDto.getLogin()) && checkEmailExistence(userDto.getEmail())){
            throw new RuntimeException("Not unique login or pass");
        }

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        return userRepository.save(user);
    }

    private boolean checkLoginExistence(String login) {
        return (userRepository.findByLogin(login) != null);
    }

    private boolean checkEmailExistence(String email) {
        return (userRepository.findByEmail(email) != null);
    }
}
