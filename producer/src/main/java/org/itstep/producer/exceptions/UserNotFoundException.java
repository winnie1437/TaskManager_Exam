package org.itstep.producer.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(final Long id) {
        super("User id not found " + id);
    }
}
