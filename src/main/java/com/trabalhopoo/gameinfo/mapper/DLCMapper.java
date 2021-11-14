package com.trabalhopoo.gameinfo.mapper;

import com.trabalhopoo.gameinfo.dto.DLCDTO;
import com.trabalhopoo.gameinfo.entity.DLC;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DLCMapper {
    DLCMapper INSTANCE = Mappers.getMapper(DLCMapper.class);

    DLC toModel(DLCDTO dlcDTO);

    DLCDTO toDTO(DLC dLC);
}
