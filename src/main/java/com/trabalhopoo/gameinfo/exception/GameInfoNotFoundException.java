package com.trabalhopoo.gameinfo.exception;

import javax.persistence.EntityNotFoundException;

public class GameInfoNotFoundException extends EntityNotFoundException {
    public GameInfoNotFoundException(Long id) {
        super(String.format("Game with id %s not exists!", id));
    }
}
