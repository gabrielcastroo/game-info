package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.builder.GameInfoDTOBuilder;
import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameInfoServiceTest {

    private final GameInfoMapper gameInfoMapper = GameInfoMapper.INSTANCE;

    @Mock
    private GameInfoRepository gameInfoRepository;

    @InjectMocks
    private GameInfoService gameInfoService;

    private GameInfoDTOBuilder gameInfoDTOBuilder;

    @BeforeEach
    void setup() {
        gameInfoDTOBuilder = GameInfoDTOBuilder.builder().build();
        gameInfoDTOBuilder.buildGameInfoDTO();
    }
}
