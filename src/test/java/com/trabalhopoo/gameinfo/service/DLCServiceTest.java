package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.builder.DLCDTOBuilder;
import com.trabalhopoo.gameinfo.mapper.DLCMapper;
import com.trabalhopoo.gameinfo.repository.DLCRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DLCServiceTest {

    private final DLCMapper dlcMapper = DLCMapper.INSTANCE;

    @Mock
    private DLCRepository dlcRepository;

    @InjectMocks
    private DLCService dlcService;

    private DLCDTOBuilder dlcDTOBuilder;

    @BeforeEach
    void setup() {
        dlcDTOBuilder = DLCDTOBuilder.builder().build();
        dlcDTOBuilder.buildDlcDTO();
    }
}
