package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.DLCDTO;
import com.trabalhopoo.gameinfo.service.DLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/game/dlc")
public class DLCController implements DLCControllerDocs{

    private DLCService dlcService;

    @Autowired
    public DLCController(DLCService dlcService) {
        this.dlcService = dlcService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DLCDTO create(@RequestBody @Valid DLCDTO dlcDTO) {
        return dlcService.create(dlcDTO);
    }
}
