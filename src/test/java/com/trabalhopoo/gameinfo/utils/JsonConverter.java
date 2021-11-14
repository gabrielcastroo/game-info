package com.trabalhopoo.gameinfo.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trabalhopoo.gameinfo.dto.GameInfoDTO;

public class JsonConverter {
    public static String asJsonString(GameInfoDTO expectedCreatedGameInfoDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(expectedCreatedGameInfoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
