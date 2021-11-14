package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.dto.DLCDTO;
import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.DLC;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.exception.GameInfoNotFoundException;
import com.trabalhopoo.gameinfo.mapper.DLCMapper;
import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.DLCRepository;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DLCService {

    private final static DLCMapper dlcMapper = DLCMapper.INSTANCE;

    private DLCRepository dlcRepository;

    @Autowired
    public DLCService(DLCRepository dlcRepository) {
        this.dlcRepository = dlcRepository;
    }

    public DLCDTO create(DLCDTO dlcDTO) {
        DLC dlcToCreate = dlcMapper.toModel(dlcDTO);
        DLC createdDlc= dlcRepository.save(dlcToCreate);
        return dlcMapper.toDTO(createdDlc);
    }
    public List<DLCDTO> findAll(){
        return dlcRepository.findAll()
                .stream()
                .map(dlcMapper::toDTO)
                .collect(Collectors.toList());
    }
}
