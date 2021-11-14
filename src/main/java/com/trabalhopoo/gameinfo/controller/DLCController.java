package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.service.DLCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game/dlc")
public class DLCController implements DLCControllerDocs{

    private DLCService dlcService;

    @Autowired
    public DLCController(DLCService dlcService) {
        this.dlcService = dlcService;
    }
}
