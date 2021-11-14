package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.builder.GameInfoDTOBuilder;
import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.exception.GameInfoAlreadyExistException;
import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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

    @Test
    void whenNewGameInfoIsInformedThenItShouldBeCreated() {
        //given
        GameInfoDTO expectedGameInfoToCreateDTO = gameInfoDTOBuilder.buildGameInfoDTO();
        GameInfo expectedCreateGameInfo = gameInfoMapper.toModel(expectedGameInfoToCreateDTO);

        //when
        Mockito.when(gameInfoRepository.save(expectedCreateGameInfo)).thenReturn(expectedCreateGameInfo);
        Mockito.when(gameInfoRepository.findByName(expectedGameInfoToCreateDTO.getName())).thenReturn(Optional.empty());

        GameInfoDTO createdGameInfoDTO = gameInfoService.create(expectedGameInfoToCreateDTO);

        //then
        MatcherAssert.assertThat(createdGameInfoDTO, Is.is(IsEqual.equalTo(expectedGameInfoToCreateDTO)));
    }

    @Test
    void whenExistingAuthorIsInformedThenAnExceptionShouldBeThrown() {

        GameInfoDTO expectedGameInfoToCreateDTO = gameInfoDTOBuilder.buildGameInfoDTO();
        GameInfo expectedCreateGameInfo = gameInfoMapper.toModel(expectedGameInfoToCreateDTO);

        Mockito.when(gameInfoRepository.findByName(expectedGameInfoToCreateDTO.getName()))
                .thenReturn(Optional.of(expectedCreateGameInfo));

        Assertions.assertThrows(GameInfoAlreadyExistException.class, () -> gameInfoService.create(expectedGameInfoToCreateDTO));

    }
}
