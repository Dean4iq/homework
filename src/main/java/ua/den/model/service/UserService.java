package ua.den.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.den.model.dto.NonSensitiveUserData;
import ua.den.model.dto.SensitiveUserData;
import ua.den.model.dto.UserDto;
import ua.den.model.entity.User;
import ua.den.model.exceptions.PasswordNotMatchingException;
import ua.den.model.exceptions.UserNotFoundException;
import ua.den.model.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(11);

    public User retrieveUserData(String login) {
        return userRepository.findByLogin(login);
    }

    public User registerNewUser(UserDto userDto){
        User user = new User();

        if (checkLoginExistence(userDto.getLogin()) && checkEmailExistence(userDto.getEmail())){
            throw new RuntimeException("Not unique login or pass");
        }

        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        return userRepository.save(user);
    }

    public NonSensitiveUserData getNonSensitiveUserDataByLogin(String login) {
        User user = userRepository.findByLogin(login);

        NonSensitiveUserData userData = new NonSensitiveUserData();

        userData.setLogin(user.getLogin());
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        userData.setLastName(user.getLastName());
        userData.setPatronymicName(user.getPatronymicName());

        return userData;
    }

    public void updateUserData(NonSensitiveUserData userData) throws UserNotFoundException {
        User user = userRepository.findByLogin(userData.getLogin());

        if (user == null) {
            throw new UserNotFoundException(userData.getLogin());
        }

        user.setEmail(userData.getEmail());
        user.setLastName(userData.getLastName());
        user.setName(userData.getName());
        user.setPatronymicName(userData.getPatronymicName());

        userRepository.save(user);
    }

    public void updateUserData(SensitiveUserData userData, String login) throws PasswordNotMatchingException {
        User user = userRepository.findByLogin(login);

        if (encryptPassword(userData.getOldPassword()).equals(user.getPassword())){
            user.setPassword(userData.getNewPassword());

            userRepository.save(user);
        } else {
            throw new PasswordNotMatchingException(login);
        }
    }

    private String encryptPassword(String password) {
        return PASSWORD_ENCODER.encode(password);
    }

    private boolean checkLoginExistence(String login) {
        return (userRepository.findByLogin(login) != null);
    }

    private boolean checkEmailExistence(String email) {
        return (userRepository.findByEmail(email) != null);
    }
}
