package com.trabalhopoo.gameinfo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/game/information")
public class GameInfoController {

    @ApiOperation(value = "Return OK")
    @ApiResponse(code = 200, message = "Success Method Return")

    @GetMapping
    public String hello() {
        return "Running . . .";
    }
}
