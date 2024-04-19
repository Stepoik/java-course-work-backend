package ru.mirea.dentalclinic.exceptions;

import static ru.mirea.dentalclinic.exceptions.Constants.USER_ALREADY_EXIST;

public class UserExistException extends Exception {
    public UserExistException(String message) {
        super(message);
    }

    public UserExistException() {
        super(USER_ALREADY_EXIST);
    }
}
