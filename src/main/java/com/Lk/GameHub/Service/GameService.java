package com.Lk.GameHub.Service;

import com.Lk.GameHub.DTOs.GameDTO;
import com.Lk.GameHub.Entity.Game;
import com.Lk.GameHub.Repository.FavoritosRepository;
import com.Lk.GameHub.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final ConverterDados converterDados;
    private final GameRepository gameRepository;
    private final FavoritosRepository favoritosRepository;

    public void adicionarGame(Game game){
        Optional<Game> gameRep = gameRepository.findById(game.getIdGame());

        if (gameRep.isPresent()){
            System.out.println("Game "+gameRep.get().getTitulo()+" ja existe no banco.");
            return;
        }

        gameRepository.save(game);
        System.out.println(game.getTitulo()+" adicionado com sucesso!");
    }

    public void adicionarGameListDto(List<GameDTO> dto){
        List<Game> games = converterDados.converteGame(dto);

        games.forEach(this::adicionarGame);
    }
}
