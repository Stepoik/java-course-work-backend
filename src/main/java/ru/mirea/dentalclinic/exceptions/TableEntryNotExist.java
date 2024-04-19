package ru.mirea.dentalclinic.exceptions;

public class TableEntryNotExist extends RuntimeException {
    public TableEntryNotExist(String message) {
        super(message);
    }
}
