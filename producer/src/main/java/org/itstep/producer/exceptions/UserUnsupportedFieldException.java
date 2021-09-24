package org.itstep.producer.exceptions;

public class UserUnsupportedFieldException extends RuntimeException {
    public UserUnsupportedFieldException(final Long id) {
        super("Password could not be set on " + id);
    }
}
