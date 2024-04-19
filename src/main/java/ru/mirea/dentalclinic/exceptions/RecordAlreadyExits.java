package ru.mirea.dentalclinic.exceptions;

import static ru.mirea.dentalclinic.exceptions.Constants.RECORD_ALREADY_EXIST;

public class RecordAlreadyExits extends RuntimeException {
    public RecordAlreadyExits() {
        super(RECORD_ALREADY_EXIST);
    }

    public RecordAlreadyExits(String message) {
        super(message);
    }
}
