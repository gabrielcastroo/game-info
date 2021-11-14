package com.trabalhopoo.gameinfo.service;

import com.trabalhopoo.gameinfo.builder.DLCDTOBuilder;
import com.trabalhopoo.gameinfo.dto.DLCDTO;
import com.trabalhopoo.gameinfo.entity.DLC;
import com.trabalhopoo.gameinfo.mapper.DLCMapper;
import com.trabalhopoo.gameinfo.repository.DLCRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Test
    void whenNewDLCIsInformedThenItShouldBeCreated() {
        //given
        DLCDTO expectedDLCToCreateDTO = dlcDTOBuilder.buildDlcDTO();
        DLC expectedCreateDLC = dlcMapper.toModel(expectedDLCToCreateDTO);

        //when
        Mockito.when(dlcRepository.save(expectedCreateDLC)).thenReturn(expectedCreateDLC);

        DLCDTO createdDLCDTO = dlcService.create(expectedDLCToCreateDTO);

        //then
        MatcherAssert.assertThat(createdDLCDTO, Is.is(IsEqual.equalTo(expectedDLCToCreateDTO)));

    }
}
