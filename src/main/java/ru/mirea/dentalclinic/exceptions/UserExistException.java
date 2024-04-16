package ru.mirea.dentalclinic.exceptions;

public class UserExistException extends Exception {
    public static final String USER_ALREADY_EXIST = "User with this name already exist";
    public UserExistException(String message) {
        super(message);
    }
}
