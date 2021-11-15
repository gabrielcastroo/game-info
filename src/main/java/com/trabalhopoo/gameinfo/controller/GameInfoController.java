package com.trabalhopoo.gameinfo.controller;

import com.trabalhopoo.gameinfo.dto.GameInfoDTO;
import com.trabalhopoo.gameinfo.entity.GameInfo;
import com.trabalhopoo.gameinfo.service.GameInfoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/api/game/information")
public class GameInfoController implements GameInfoControllerDocs{

    private GameInfoService gameInfoService;

    @Autowired
    public GameInfoController(GameInfoService gameInfoService) {
        this.gameInfoService = gameInfoService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameInfoDTO create(@RequestBody @Valid GameInfoDTO gameInfoDTO) {
        return gameInfoService.create(gameInfoDTO);
    }

    @GetMapping("/{id}")
    public GameInfoDTO findById(@PathVariable Long id) {
        return gameInfoService.findById(id);
    }

    @GetMapping
    public List<GameInfoDTO> findAll() {
        return gameInfoService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        gameInfoService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public GameInfoDTO update(@PathVariable Long id, @RequestBody @Valid GameInfoDTO gameInfoToUpdateDTO) {
        return gameInfoService.update(id, gameInfoToUpdateDTO);
    }

}
