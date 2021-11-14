package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Game Information Management")
public interface GameInfoControllerDocs {

    @ApiOperation(value = "Game Info Creation Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Game Info Created"),
            @ApiResponse(code = 400, message = "Missing Required Fields")
    })
    GameInfoDTO create(GameInfoDTO gameInfoDTO);
}
