package com.trabalhopoo.gameinfo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String urlImage;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String developer;

    @Column(nullable = false)
    private Integer soldCopies;

    @Column(nullable = false)
    private String distributor;

    @Column(columnDefinition = "integer default 0")
    private Integer score;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String requirements;

    @Column(nullable = false)
    private String genre;
}
