package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.service.GameInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping("/api/game/information")
public class GameInfoController implements GameInfoControllerDocs{

    private GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameInfoDTO create(@RequestBody @Valid GameInfoDTO gameInfoDTO) {
        return gameInfoService.create(gameInfoDTO);
    }
}
