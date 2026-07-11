package com.Lk.GameHub.Controller;

import com.Lk.GameHub.DTOs.GameDtoRest;
import com.Lk.GameHub.Service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/games")
    public List<GameDtoRest> listarGames(){
        return gameService.obterTodosgames();
    }
}
