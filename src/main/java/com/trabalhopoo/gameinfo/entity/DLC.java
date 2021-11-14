package com.trabalhopoo.gameinfo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class DLC extends Game {

    @JoinColumn
    @ManyToOne(cascade = {CascadeType.MERGE})
    private GameInfo gameInfo;

}
