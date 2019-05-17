package ua.den.model.exceprions;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class PasswordNotMatchingException extends InvalidArgumentException {
    public PasswordNotMatchingException(String string) {
        super(new String[]{string});
    }
}
