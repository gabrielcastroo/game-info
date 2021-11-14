package com.trabalhopoo.gameinfo.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trabalhopoo.gameinfo.builder.GameInfoDTOBuilder;
import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.service.GameInfoService;
import com.trabalhopoo.gameinfo.utils.JsonConverter;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
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
    @Test
    void whenPOSTIsCalledThenStatusCreatedShouldBeReturned() throws Exception {
        GameInfoDTO expectedCreatedGameInfoDTO = gameInfoDTOBuilder.buildGameInfoDTO();

        Mockito.when(gameInfoService.create(expectedCreatedGameInfoDTO))
                .thenReturn(expectedCreatedGameInfoDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/game/information")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonConverter.asJsonString(expectedCreatedGameInfoDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(expectedCreatedGameInfoDTO.getId().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is(expectedCreatedGameInfoDTO.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.urlImage", Is.is(expectedCreatedGameInfoDTO.getUrlImage())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.releaseDate", Is.is(expectedCreatedGameInfoDTO.getReleaseDate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description", Is.is(expectedCreatedGameInfoDTO.getDescription())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.developer", Is.is(expectedCreatedGameInfoDTO.getDeveloper())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.soldCopies", Is.is(expectedCreatedGameInfoDTO.getSoldCopies().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.distributor", Is.is(expectedCreatedGameInfoDTO.getDistributor())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.score", Is.is(expectedCreatedGameInfoDTO.getScore().intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Is.is(expectedCreatedGameInfoDTO.getPrice().doubleValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.requirements", Is.is(expectedCreatedGameInfoDTO.getRequirements())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre", Is.is(expectedCreatedGameInfoDTO.getGenre())));

    }


}

