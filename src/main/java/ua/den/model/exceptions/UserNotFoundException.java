package ua.den.model.exceptions;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class UserNotFoundException extends InvalidArgumentException {
    public UserNotFoundException(String string) {
        super(new String[]{string});
    }
}
