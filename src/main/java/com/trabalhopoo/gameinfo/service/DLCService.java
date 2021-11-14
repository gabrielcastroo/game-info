package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.mapper.DLCMapper;
import com.trabalhopoo.gameinfo.mapper.GameInfoMapper;
import com.trabalhopoo.gameinfo.repository.DLCRepository;
import com.trabalhopoo.gameinfo.repository.GameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DLCService {

    private final static DLCMapper dLCMapper = DLCMapper.INSTANCE;

    private DLCRepository dlcRepository;

    @Autowired
    public DLCService(DLCRepository dlcRepository) {
        this.dlcRepository = dlcRepository;
    }
}
