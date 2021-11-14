package com.trabalhopoo.gameinfo.builder;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import lombok.Builder;

@Builder
public class GameInfoDTOBuilder {

    @Builder.Default
    private final Long id = 1L;
    @Builder.Default
    private final String name = "Game Teste";
    @Builder.Default
    private final String urlImage = "https://vscjava.gallerycdn.vsassets.io/extensions/vscjava/vscode-spring-initializr/0.7.0/1615883353860/Microsoft.VisualStudio.Services.Icons.Default";
    @Builder.Default
    private final String releaseDate = "22/05/2021";
    @Builder.Default
    private final String description = "Descrição do Game Teste";
    @Builder.Default
    private final String developer = "Gabriel Castro";
    @Builder.Default
    private final Integer soldCopies = 1564;
    @Builder.Default
    private final String distributor = "POO Games";
    @Builder.Default
    private final int score = 99;
    @Builder.Default
    private final float price = 196.00F;
    @Builder.Default
    private final String requirements = "Intel Core I7, Nvidia Geforce, 64GB RAM";
    @Builder.Default
    private final String genre = "Aventura";

    public GameInfoDTO buildGameInfoDTO(){
        return new GameInfoDTO(id,name,urlImage,releaseDate,
                description,developer,soldCopies,distributor,
                score,price,requirements,genre);
    }
}
