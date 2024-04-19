package ru.mirea.dentalclinic.exceptions;

import static ru.mirea.dentalclinic.exceptions.Constants.PROCEDURE_NOT_EXIST;

public class ProcedureNotExist extends RuntimeException {

    public ProcedureNotExist() {
        super(PROCEDURE_NOT_EXIST);
    }

    public ProcedureNotExist(String message) {
        super(message);
    }
}
