package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.DLCDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("DLC Management")
public interface DLCControllerDocs {

    @ApiOperation(value = "DLC Creation Operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success DLC Created"),
            @ApiResponse(code = 400, message = "Missing Required Fields")
    })
    public DLCDTO create(DLCDTO dlcDTO);
}
