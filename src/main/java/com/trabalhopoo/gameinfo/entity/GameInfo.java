package com.trabalhopoo.gameinfo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GameInfo")

public class GameInfo extends Game{

    @OneToMany(mappedBy = "gameInfo", fetch = FetchType.LAZY)
    private List<DLC> dlc;

}
