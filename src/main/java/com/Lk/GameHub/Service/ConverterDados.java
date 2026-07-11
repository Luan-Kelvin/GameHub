package com.Lk.GameHub.Service;
;
import com.Lk.GameHub.DTOs.GameDTO;
import com.Lk.GameHub.Entity.Game;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConverterDados {
    private ObjectMapper mapper = new ObjectMapper();

    public List<Game> converteGame(List<GameDTO> dto){
        if (dto.isEmpty()){
            throw new RuntimeException("Lista esta vazia.");
        }

        return dto.stream()
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
}
