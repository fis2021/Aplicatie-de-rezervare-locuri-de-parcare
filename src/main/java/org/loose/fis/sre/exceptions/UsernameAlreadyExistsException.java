package org.loose.fis.sre.exceptions;


public class UsernameAlreadyExistsException extends Exception {

    private String username;

    public UsernameAlreadyExistsException(String username) {
        super(username);
        this.username = username;
    }
}
