package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Game Information Management")
public interface GameInfoControllerDocs {

    @ApiOperation(value = "Game Info Creation Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success Game Info Created"),
            @ApiResponse(code = 400, message = "Missing Required Fields")
    })
    GameInfoDTO create(GameInfoDTO gameInfoDTO);


    @ApiOperation(value = "Find Game By ID Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Game Info Found By ID"),
            @ApiResponse(code = 404, message = "Game Not Found")
    })
    GameInfoDTO findById(Long id);

    @ApiOperation(value = "List All Games Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Game Info Listed"),
    })
    List<GameInfoDTO> findAll();

    @ApiOperation(value = "Delete Game By ID Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success Game Info Deleted By ID"),
            @ApiResponse(code = 404, message = "Game Not Found")
    })
    void delete(Long id);

    @ApiOperation(value = "Game Info Update Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success Game Info Created"),
            @ApiResponse(code = 400, message = "Missing Required Fields")
    })
    GameInfoDTO update(Long id, GameInfoDTO gameInfoToUpdateDTO);
}
