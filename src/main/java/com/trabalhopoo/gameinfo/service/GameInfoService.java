package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.exception.GameInfoAlreadyExistException;
import com.trabalhopoo.gameinfo.exception.GameInfoNotFoundException;
import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameInfoService {

    private final static GameInfoMapper gameInfoMapper = GameInfoMapper.INSTANCE;

    private GameInfoRepository gameInfoRepository;

    @Autowired
    public GameInfoService(GameInfoRepository gameInfoRepository) {
        this.gameInfoRepository = gameInfoRepository;
    }

    public GameInfoDTO create(GameInfoDTO gameInfoDTO) {
        gameInfoRepository.findByName(gameInfoDTO.getName())
                .ifPresent(gameInfo -> {throw new GameInfoAlreadyExistException(gameInfo.getName());});

        GameInfo gameInfoToCreate = gameInfoMapper.toModel(gameInfoDTO);
        GameInfo createdGameInfo = gameInfoRepository.save(gameInfoToCreate);
        return gameInfoMapper.toDTO(createdGameInfo);
    }
    public GameInfoDTO findById(Long id) {
       GameInfo foundGame = gameInfoRepository.findById(id)
               .orElseThrow(()-> new GameInfoNotFoundException(id));
       return gameInfoMapper.toDTO(foundGame);
    }

    public List<GameInfoDTO> findAll(){
        return gameInfoRepository.findAll()
                .stream()
                .map(gameInfoMapper::toDTO)
                .collect(Collectors.toList());
    }

}
