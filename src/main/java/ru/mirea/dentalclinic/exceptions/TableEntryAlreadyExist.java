package ru.mirea.dentalclinic.exceptions;

public class TableEntryAlreadyExist extends RuntimeException {
    public TableEntryAlreadyExist(String message) {
        super(message);
    }
}
