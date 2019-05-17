package ua.den.model.exceprions;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class UserNotFoundException extends InvalidArgumentException {
    public UserNotFoundException(String string) {
        super(new String[]{string});
    }
}
