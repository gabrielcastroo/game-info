package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInfoService {

    private final static GameInfoMapper gameInfoMapper = GameInfoMapper.INSTANCE;

    private GameInfoRepository gameInfoRepository;

    @Autowired
    public GameInfoService(GameInfoRepository gameInfoRepository) {
        this.gameInfoRepository = gameInfoRepository;
    }

}
