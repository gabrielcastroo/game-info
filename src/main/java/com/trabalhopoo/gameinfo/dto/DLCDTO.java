package com.trabalhopoo.gameinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DLCDTO {
    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;

    @NotNull
    @NotEmpty
    private String urlImage;

    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String releaseDate;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String developer;

    @NotNull
    @Min(0)
    private Integer soldCopies;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String distributor;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer score;

    @NotNull
    @PositiveOrZero
    private Float price;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String requirements;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String genre;
}
