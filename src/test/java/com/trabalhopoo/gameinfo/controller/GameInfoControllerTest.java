package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.builder.GameInfoDTOBuilder;
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
public class GameInfoControllerTest {

    @Mock
    private GameInfoService gameInfoService;

    @InjectMocks
    private GameInfoController gameInfoController;

    private MockMvc mockMvc;

    private GameInfoDTOBuilder gameInfoDTOBuilder;

    @BeforeEach
    void setUp() {
        gameInfoDTOBuilder = GameInfoDTOBuilder.builder().build();
        mockMvc = MockMvcBuilders.standaloneSetup(gameInfoController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }
}
