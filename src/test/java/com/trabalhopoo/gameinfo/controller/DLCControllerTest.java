package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.builder.DLCDTOBuilder;
import com.trabalhopoo.gameinfo.builder.GameInfoDTOBuilder;
import com.trabalhopoo.gameinfo.service.DLCService;
import com.trabalhopoo.gameinfo.service.GameInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ExtendWith(MockitoExtension.class)
public class DLCControllerTest {

    @Mock
    private DLCService dlcService;

    @InjectMocks
    private DLCController dlcController;

    private MockMvc mockMvc;

    private DLCDTOBuilder dlcdtoBuilder;

    @BeforeEach
    void setUp() {
        dlcdtoBuilder = DLCDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(dlcController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }
}
