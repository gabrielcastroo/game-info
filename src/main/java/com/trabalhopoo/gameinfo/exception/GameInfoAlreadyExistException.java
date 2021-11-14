package com.trabalhopoo.gameinfo.exception;

import javax.persistence.EntityExistsException;

public class GameInfoAlreadyExistException extends EntityExistsException {
    public GameInfoAlreadyExistException(String name) {
        super(String.format("User with name %s already exists!", name));
    }
}
