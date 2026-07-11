package com.Lk.GameHub.Service;
;
import com.Lk.GameHub.DTOs.GameDTO;
import com.Lk.GameHub.DTOs.GameDtoRest;
import com.Lk.GameHub.Entity.Game;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ConverterDados {
    private ObjectMapper mapper = new ObjectMapper();

    public List<Game> converteGame(List<GameDTO> dto){
        if (dto.isEmpty()){
            throw new RuntimeException("Lista esta vazia.");
        }

        return dto.stream()
                .filter(Objects::nonNull)
                .map(gdto -> new Game(
                        gdto.idGame(),
                        gdto.titulo(),
                        gdto.genero(),
                        gdto.descricao(),
                        gdto.plataforma(),
                        gdto.desenvolvedora(),
                        LocalDate.parse(gdto.dataLancamento())
                ))
                .toList();
    }

    public List<GameDtoRest> converterGameDto(List<Game> games){
        return games.stream()
                .map(g -> new GameDtoRest(
                        g.getIdGame(),
                        g.getTitulo(),
                        g.getGenero(),
                        g.getDescricao(),
                        g.getPlataforma(),
                        g.getDesenvolvedora(),
                        String.valueOf(g.getDataLancamento())
                ))
                .toList();
    }
}
