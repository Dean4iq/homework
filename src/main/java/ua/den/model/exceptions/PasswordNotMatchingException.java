package ua.den.model.exceptions;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class PasswordNotMatchingException extends InvalidArgumentException {
    public PasswordNotMatchingException(String string) {
        super(new String[]{string});
    }
}
