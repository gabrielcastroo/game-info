package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.service.GameInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/game/information")
public class GameInfoController implements GameInfoControllerDocs{

    private GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }
}
