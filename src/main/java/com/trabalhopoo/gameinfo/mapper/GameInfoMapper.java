package com.trabalhopoo.gameinfo.mapper;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameInfoMapper {

    GameInfoMapper INSTANCE = Mappers.getMapper(GameInfoMapper.class);

    GameInfo toModel(GameInfoDTO gameInfoDTO);

    GameInfoDTO toDTO(GameInfo gameInfo);

}
